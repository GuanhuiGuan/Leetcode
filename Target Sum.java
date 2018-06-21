class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return dp(nums, S);
        // return recursive(nums, S);
    }
    
    //** O(n^2) recursive */
    public int recursive(int[] nums, int S) {
        return recur(0, nums, S);
    }
    
    public int recur(int i, int[] nums, int S) {
        if(i == nums.length)    return S == 0? 1: 0;
        return recur(i+1, nums, S - nums[i]) + recur(i+1, nums, S + nums[i]);
    }
    
    //** O(n*sum) DP */
    public int dp(int[] nums, int S) {
        // Find the max and min of array combinatiions
        int sum = 0;
        for(int num: nums)  sum += num;
        if(S > sum || -S < -sum)    return 0;
        
        // Set up dp array to store number of ways to get to these values
        int dpLen = 2*sum + 1;
        int[] dp = new int[dpLen];
        // Set way to be 0 to 1
        dp[sum + 0] = 1;
        
        for(int i = 0; i < nums.length; i++) {
            // New dp array for next level
            int[] nextDp = new int[dpLen];
            for(int j = 0; j < dpLen; j++) {
                if(dp[j] > 0) {
                    nextDp[j + nums[i]] += dp[j];
                    nextDp[j - nums[i]] += dp[j];
                }
            }
            // Update dp array
            dp = nextDp;
        }
        
        return dp[sum + S];
    }
}