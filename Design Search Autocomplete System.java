class AutocompleteSystem {
    
    private Trie root = new Trie();
    private Trie cur = root;
    private String prefix = "";

    public AutocompleteSystem(String[] sentences, int[] times) {
        for(int i = 0; i < sentences.length; i++) {
            store(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        // End of input
        if(c == '#') {
            store(prefix, 1);
            prefix = "";
            cur = root;
            return new ArrayList<>();
        }
        
        // Otherwise, search the current node cur
        prefix = prefix + c;
        // being null means no match in previous iteration
        if(cur == null || !cur.children.containsKey(c)) {
            cur = null;
            return new ArrayList<>();
        }
        // If found, get count map and push to queue
        cur = cur.children.get(c);
        Map<String, Integer> counts = cur.counts;
        Queue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                // cnt desc || str asc
                return o1.cnt == o2.cnt? o1.s.compareTo(o2.s): o2.cnt - o1.cnt;
            }
        });
        for(String s: counts.keySet()) {
            heap.offer(new Pair(s, counts.get(s)));
        }
        
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 3 && !heap.isEmpty(); i++) {
            res.add(heap.poll().s);
        }
        return res;
    }
    
    // -------------- Helpers ------------------
    
    private class Trie {
        public Map<String, Integer> counts = new HashMap<>();
        public Map<Character, Trie> children = new HashMap<>();
        public boolean isWord = false;
    }
    
    //** Used in heap */
    private class Pair {
        public String s;
        public Integer cnt;
        
        // String and its count
        public Pair(String s, Integer cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }
    
    //** Store sentence in trie */
    private void store(String s, int cnt) {
        Trie node = root;
        for(char c: s.toCharArray()) {
            Trie next = node.children.get(c);
            if(next == null)    next = new Trie();
            // Accumulate the counts of s
            next.counts.put(s, next.counts.getOrDefault(s, 0) + cnt);
            node.children.put(c, next);
            node = next;
        }
        node.isWord = true;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */