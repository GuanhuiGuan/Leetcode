class Trie {
    
    class Node {
        Node[] children;
        boolean isEnd;
        
        public Node() {
            children = new Node[26];
        }
    }
    
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(node.children[word.charAt(i) - 'a'] == null) node.children[word.charAt(i) - 'a'] = new Node();
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isEnd = true;
        System.out.println("Word '" + word + "' inserted!!");
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(node.children[word.charAt(i) - 'a'] == null) return false;
            node = node.children[word.charAt(i) - 'a'];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0; i < prefix.length(); i++) {
            if(node.children[prefix.charAt(i) - 'a'] == null) return false;
            node = node.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */