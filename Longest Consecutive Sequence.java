class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num: nums) {
            // skip duplicates
            if(map.containsKey(num)) {
                continue;
            }
            else {
                // get left and right neighbors lengths
                int left = map.containsKey(num - 1)? map.get(num - 1): 0;
                int right = map.containsKey(num + 1)? map.get(num + 1): 0;
                
                int curLen = 1 + left + right;
                res = Math.max(res, curLen);
                map.put(num, curLen);
                // also update neighbors
                map.put(num - left, curLen);
                map.put(num + right, curLen);
            }
        }
        return res;
    }
}