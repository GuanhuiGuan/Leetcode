class TwoSum {
    // at least one operation has to be O(n)
    // we could also have an extra list to store all elements, and map is cleared and used only during every find
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number))    map.put(number, 2); // deal with duplicates
        else    map.put(number, 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int x = entry.getKey(), y = value-x, count = entry.getValue();
            if(map.containsKey(y)) {
                if(x != y || count == 2)    return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */