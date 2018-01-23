class TwoSum {
    // add O(1), find O(n): map to save num and quantities
    Map<Integer, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TwoSum() {
        
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)) map.put(number, 2);
        else    map.put(number, 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            int x = iter.next();
            int y = value - x;
            if(map.containsKey(y)) {
                if(y != x || map.get(x) == 2)   return true;
            }
        }
        return false;
    }
    
//  // add O(n), find O(1): set to save all sums
//     Set<Integer> nums = new HashSet<>(), sums = new HashSet<>();

//     /** Initialize your data structure here. */
//     public TwoSum() {
        
//     }
    
//     /** Add the number to an internal data structure.. */
//     public void add(int number) {
//         if(nums.contains(number)) {
//             sums.add(2*number);
//         }
//         else {
//             Iterator<Integer> iter = nums.iterator();
//             while(iter.hasNext())   sums.add(number+iter.next());
//             nums.add(number);
//         }
//     }
    
//     /** Find if there exists any pair of numbers which sum is equal to the value. */
//     public boolean find(int value) {
//         return sums.contains(value);
//     }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */