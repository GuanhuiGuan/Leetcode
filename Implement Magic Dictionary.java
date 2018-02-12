class MagicDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
    
    TrieNode root;
    

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s: dict) {
            build(s);
        }
    }
    
    public void build(String s) {
        char[] cs = s.toCharArray();
        TrieNode node = root;
        for(int i = 0; i < cs.length; i++) {
            if(node.children[cs[i] - 'a'] == null) {
                node.children[cs[i] - 'a'] = new TrieNode();
            }
            node = node.children[cs[i] - 'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] cs = word.toCharArray();
        // split into 2 loops, outer loop allow one alteration, inner loop does not
        for(int i = 0; i < cs.length; i++) {
            // try alterations at every position for word
            char ori = cs[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c == ori)    continue;
                cs[i] = c;
                if(afterAlter(cs))  return true;
            }
            cs[i] = ori;
        }
        // no alteration
        return false;
    }
    
    public boolean afterAlter(char[] cs) {
        // after alter, if it is word
        TrieNode node = root;
        for(int i = 0; i < cs.length; i++) {
            if(node.children[cs[i]-'a'] == null)    return false;
            node = node.children[cs[i]-'a'];
        }
        return node.isEnd;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */