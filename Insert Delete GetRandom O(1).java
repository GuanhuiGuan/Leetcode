class RandomizedSet {
    
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))    return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))   return false;
        // Swap with last
        int index = map.get(val);
        int n = list.size();
        map.put(list.get(n-1), index);
        map.remove(val);
        swap(index, n-1);
        list.remove(n-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int ri = rand.nextInt(list.size());
        return list.get(ri);
    }
    
    /** Swap elements. */
    public void swap(int i, int j) {
        int t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */