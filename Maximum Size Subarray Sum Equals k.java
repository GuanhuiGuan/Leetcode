class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // check current sum of all previous nums, and current sum - any previous sum
        int sum = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();    // store previous sums and indices
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k)    maxLen = i+1; // must >= all lengths before
            else if(map.containsKey(sum-k)) {
                maxLen = Math.max(maxLen, i-map.get(sum-k));
            }
            // keep the earliest index of such sum
            if(!map.containsKey(sum))   map.put(sum, i);
        }
        return maxLen;
    }
}