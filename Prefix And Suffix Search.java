class WordFilter {
    Trie root = new Trie();
    Map<String, Integer> scores = new HashMap<>();
    int res = -1;

    public WordFilter(String[] words) {
        for(int i = 0; i < words.length; i++) {
            insert(i, words[i]);
            // Score is the index
            scores.put(words[i], i);
        }
    }
    
    public int f(String prefix, String suffix) {
        // Search prefix
        Trie node = searchPrefix(prefix);
        
        // If no prefix, return
        if(node == null)    return -1;
        
        // Reset res
        res = -1;
        // DFS search suffix from matched prefix node
        searchSuffix(node, suffix);
        
        return res;
        
    }
    
    // ************* Helpers *******************
    private void insert(int i, String word) {
        Trie node = root;
        for(char c: word.toCharArray()) {
            if(node.children[c-'a'] == null)    node.children[c-'a'] = new Trie();
            node = node.children[c-'a'];
        }
        node.word = word;
    }
    
    private Trie searchPrefix(String prefix) {
        Trie node = root;
        for(char c: prefix.toCharArray()) {
            if(node.children[c-'a'] == null)    return null;
            node = node.children[c-'a'];
        }
        return node;
    }
    
    //** DFS search suffix */
    private void searchSuffix(Trie node, String suffix) {
        // If it's a word, check if fits the word best
        if(node.word != null) {
            if(node.word.endsWith(suffix) && scores.get(node.word) > res) {
                res = scores.get(node.word);
            }
            
            // int s = node.word.length();
            // if(scores.get(node.word) > res) {
            //     while(s >= 0) {
            //         if(node.word.substring(s--).equals(suffix)) {
            //             res = scores.get(node.word);
            //             break;
            //         }
            //     }
            // }
        }
        
        // Check children with DFS
        for(int i = 0; i < 26; i++) {
            if(node.children[i] != null)    searchSuffix(node.children[i], suffix);
        }
    }
    
    class Trie {
        Trie[] children = new Trie[26];
        // Every node can only be one word
        String word;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */