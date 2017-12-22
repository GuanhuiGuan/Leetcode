class Solution {
    public int maxSubArray(int[] nums) {
        // should use dp instead of sliding window
        int n = nums.length, maxSub = 0;
        int[] dp = new int[n+1];
        dp[1] = nums[0];
        maxSub = dp[1];
        for(int i = 1; i < n; i++){
            // either previous sub plus the current OR just the current
            if(dp[i] < 0)   dp[i+1] = nums[i];
            else    dp[i+1] = dp[i] + nums[i];
            maxSub = Math.max(maxSub, dp[i+1]);
        }
        return maxSub;
    }
}