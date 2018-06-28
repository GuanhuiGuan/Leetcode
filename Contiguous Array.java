class Solution {
    public int findMaxLength(int[] nums) {
        // Presum and HashMap
        // Swap 0 with -1 for convenience
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)    nums[i] = -1;
        }
        
        // key:sum, value:earliest index to gain such sum
        Map<Integer, Integer> map = new HashMap<>();
        // 0 when no array is needed
        map.put(0, -1);
        
        int maxLen = 0, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum))    maxLen = Math.max(maxLen, (i - map.get(sum)));
            else    map.put(sum, i);
        }
        return maxLen;
    }
}