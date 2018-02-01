class Solution {
    public int findShortestSubArray(int[] nums) {
        // map1 find def, map2 find subarray range of each int
        int deg = 0;
        Map<Integer, Integer> degMap = new HashMap<>();
        Map<Integer, Integer[]> rangeMap = new HashMap<>();
        
        // init maps
        for(int i = 0; i < nums.length; i++) {
            // find deg
            degMap.put(nums[i], degMap.getOrDefault(nums[i], 0)+1);
            deg = Math.max(deg, degMap.get(nums[i]));
            // save range
            Integer[] range = rangeMap.getOrDefault(nums[i], new Integer[2]);
            if(range[0] == null)    range[0] = i;
            range[1] = i;
            rangeMap.put(nums[i], range);
        }
        // search minl
        int minl = nums.length;
        for(int key: degMap.keySet()) {
            if(degMap.get(key) == deg) {
                Integer[] range = rangeMap.get(key);
                minl = Math.min(minl, range[1]-range[0]+1);
            }
        }
        return minl;
        
//         // find max deg
//         int deg = 0;
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int num: nums) {
//             map.put(num, map.getOrDefault(num, 0)+1);
//             deg = Math.max(deg, map.get(num));
//         }
        
//         // find subarray 2ptrs
//         int minl = nums.length;
//         map.clear();
//         int s = 0;
//         for(int i = 0; i < nums.length; i++) {
//             int num = nums[i];
//             map.put(num, map.getOrDefault(num, 0)+1);
//             while(map.get(num) == deg) {
//                 minl = Math.min(minl, i-s+1);
//                 map.put(nums[s], map.get(nums[s])-1);
//                 s++;
//             }
//         }
//         return minl;
    }
}