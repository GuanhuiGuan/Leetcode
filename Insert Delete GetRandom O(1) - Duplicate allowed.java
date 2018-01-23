class RandomizedCollection {
    // set records all the indices/locations
    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }
        else {
            Set<Integer> set = new HashSet<>();
            set.add(list.size());
            map.put(val, set);
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))   return false;
        Set<Integer> set = map.get(val);
        int ind = set.iterator().next();
        map.get(val).remove(ind);
        if(ind < list.size()-1) {
            int lastI = list.size()-1, lastV = list.get(lastI);
            map.get(lastV).remove(lastI);
            map.get(lastV).add(ind);
            list.set(ind, lastV);
        }
        list.remove(list.size()-1);
        if(map.get(val).isEmpty())  map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */