class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 1 sweep, only stores previous k elements
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > k)   set.remove(nums[i-k-1]);
            if(!set.add(nums[i]))   return true;
        }
        return false;
        
        
        // Map<Integer, List<Integer>> map = new HashMap<>();
        // // 1st sweep save indices
        // for(int i = 0; i < nums.length; i++) {
        //     map.putIfAbsent(nums[i], new ArrayList<>());
        //     map.get(nums[i]).add(i);
        // }
        // // 2nd sweep check k distance
        // for(int key: map.keySet()) {
        //     List<Integer> val = map.get(key);
        //     for(int i = 0; i < val.size(); i++) {
        //         for(int j = i+1; j < val.size(); j++) {
        //             if(val.get(j)-val.get(i) <= k)    return true;
        //         }
        //     }
        // }
        // return false;
    }
}