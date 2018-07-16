class AllOne {
    
    //** A class of all keys with same value */
    private class Bucket {
        public int value;
        public Set<String> set;
        Bucket prev, next;
        public Bucket(int v) {
            this.value = v;
            set = new HashSet<>();
        }
    }
    
    private Bucket head, tail;
    private Map<String, Integer> vals;
    private Map<Integer, Bucket> bucs;

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        // Head and tail not in bucs map
        vals = new HashMap<>();
        bucs = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(vals.containsKey(key)) {
            updateKey(key, 1);
        }
        else {
            vals.put(key, 1);
            if(head.next.value != 1) {
                insertBucketAfter(new Bucket(1), head);
            }
            bucs.put(1, head.next);
            insertKeyToBucket(key, bucs.get(1));
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(vals.containsKey(key)) {
            if(vals.get(key) == 1) {
                vals.remove(key);
                deleteKeyFromBucket(key, bucs.get(1));
            }
            else    updateKey(key, -1);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev == head? "": tail.prev.set.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail? "": head.next.set.iterator().next();
    }
    
    // Helpers
    
    private void updateKey(String key, int offset) {
        // Offset is either 1 or -1
        int v = vals.get(key);
        vals.put(key, v+offset);
        Bucket cur = bucs.get(v);
        Bucket next;
        
        if(bucs.containsKey(v+offset)) {
            next = bucs.get(v+offset);
        }
        else {
            next = new Bucket(v+offset);
            insertBucketAfter(next, offset == 1? cur: cur.prev);
            bucs.put(next.value, next);
        }
        insertKeyToBucket(key, next);
        deleteKeyFromBucket(key, cur);
    }
    
    private void insertBucketAfter(Bucket b, Bucket prev) {
        b.prev = prev;
        b.next = prev.next;
        prev.next.prev = b;
        prev.next = b;
    }
    
    private void removeBucket(Bucket b) {
        b.prev.next = b.next;
        b.next.prev = b.prev;
        b.prev = null;
        b.next = null;
    }
    
    private void insertKeyToBucket(String key, Bucket b) {
        b.set.add(key);
    }
    
    private void deleteKeyFromBucket(String key, Bucket b) {
        b.set.remove(key);
        if(b.set.size() == 0) {
            removeBucket(b);
            bucs.remove(b.value);
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */