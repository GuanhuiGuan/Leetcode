class LFUCache {
    // Use LinkedHashSet to record insert order
    
    private Map<Integer, Integer> values = new HashMap<>(), counts = new HashMap<>();
    // Set of keys with corresponding counts, count as key
    private Map<Integer, Set<Integer>> sets = new HashMap<>();
    
    private int cap = 0;
    private int minFreq = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        sets.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!values.containsKey(key))   return -1;
        int c = counts.get(key);
        
        // Increment count
        counts.put(key, counts.get(key)+1);
        
        // Remove obj from current count set
        sets.get(c).remove(key);
        
        // Increase min if it is the last one with such count
        if(minFreq == c && sets.get(c).size() == 0)   minFreq++;
        
        // Insert in new increased count set
        if(!sets.containsKey(c+1))    sets.put(c+1, new LinkedHashSet<>());
        sets.get(c+1).add(key);
        return values.get(key);
    }
    
    public void put(int key, int value) {
        // Avoid corner cases
        if(cap <= 0)    return;
        
        if(values.containsKey(key)) {
            values.put(key, value);
            // Update counts and sets using get method
            get(key);
            return;
        }
        else {
            // Check if exceeds cap
            if(values.size() == cap) {
                int delKey = sets.get(minFreq).iterator().next();
                sets.get(minFreq).remove(delKey);
                values.remove(delKey);
                // counts.remove(delKey);
            }
            
            // Insert new obj and reset minFreq to 1
            minFreq = 1;
            values.put(key, value);
            counts.put(key, 1);
            sets.get(1).add(key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */