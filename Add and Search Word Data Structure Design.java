class WordDictionary {
    
    Trie root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] cs = word.toCharArray();
        Trie node = root;
        for(char c: cs) {
            if(node.children[c - 'a'] == null)  node.children[c - 'a'] = new Trie();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] cs = word.toCharArray();
        Trie node = root;
        return dfs(cs, 0, node);
    }
    
    public boolean dfs(char[] cs, int index, Trie node) {
        if(node == null)    return false;
        if(index == cs.length)  return node.isWord;
        if(cs[index] == '.') {
            for(int p = 0; p < 26; p++) {
                if(dfs(cs, index+1, node.children[p]))    return true;
            }
            return false;
        }
        else if(node.children[cs[index] - 'a'] == null) return false;
        
        return dfs(cs, index+1, node.children[cs[index] - 'a']);
    }
    
    
    class Trie {
        public Trie[] children = new Trie[26];
        public boolean isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */