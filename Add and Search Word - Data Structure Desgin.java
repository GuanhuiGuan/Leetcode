class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false; // mark if it's the end of a word
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] cs = word.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if(node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }
    
    public boolean search(char[] cs, int k, TrieNode node) {
        if(k == cs.length)  return node.isWord;
        
        char c = cs[k];
        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                if(node.children[i] != null) {
                    if(search(cs, k+1, node.children[i]))   return true;
                }
            }
        }
        else {
            if(node.children[c-'a'] == null)    return false;
            return search(cs, k+1, node.children[c-'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */