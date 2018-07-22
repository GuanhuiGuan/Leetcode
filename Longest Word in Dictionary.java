class Solution {
    
    public String longestWord(String[] words) {
        // return trie(words);
        return prefix(words);
    }
    
    // ******************** Sort and Prefix O(nlogn) **********************
    
    private String prefix(String[] words) {
        // Sort array and search if prefix exist
        String res = "";
        Arrays.sort(words);
        
        Set<String> prefix = new HashSet<>();
        // Make sure one char string can be added
        prefix.add("");
        for(String word: words) {
            // Search if (0, n-1) prefix exist
            if(prefix.contains(word.substring(0, word.length()-1))) {

                // Only add if prefix exist
                prefix.add(word);
                // Sorting guarantees lexicalgraphical order
                if(word.length() > res.length())    res = word;
            }
        }
        return res;
    }
    
    // ******************* Trie Two Passes O(nk) *************************
    
    private class Trie {
        public Trie[] children = new Trie[26];
        boolean isWord;
    }
    
    private String trie(String[] words) {
        Trie root = new Trie();
        for(String word: words) {
            insert(word, root);
        }
        
        String res = "";
        for(String word: words) {
            // Conforms the rule && longer or same length but smaller lexical order
            if(find(word, root) && 
               (res.length() < word.length() || 
                    res.length() == word.length() && res.compareTo(word) > 0))    res = word;
        }
        return res;
    }
    
    private void insert(String word, Trie root) {
        Trie node = root;
        for(char c: word.toCharArray()) {
            int i = c - 'a';
            if(node.children[i] == null)    node.children[i] = new Trie();
            node = node.children[i];
        }
        node.isWord = true;
    }
    
    private boolean find(String word, Trie root) {
        Trie node = root;
        for(char c: word.toCharArray()) {
            int i = c - 'a';
            // Only if next step is also a word
            if(node.children[i] == null || !node.children[i].isWord)    return false;
            node = node.children[i];
        }
        return true;
    }
}