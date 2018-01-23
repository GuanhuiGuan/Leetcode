class RandomizedSet {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            // swap with last num, remove last(remember to reset map too)
            if(map.get(val) != list.size()-1) {
                map.put(list.get(list.size()-1), map.get(val));
                swap(map.get(val), list.size()-1);
            }
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
        else    return false;
    }
    
    public void swap(int i, int j) {
        int t = list.get(j);
        list.set(j, list.get(i));
        list.set(i, t);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */