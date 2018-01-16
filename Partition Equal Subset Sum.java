class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for(int num: nums) sum += num;
        if(sum%2 != 0)  return false;
        sum /= 2;
        
        // 0/1 knapsack
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 0; i <= n; i++) dp[i][0] = true;
        for(int j = 1; j <= sum; j++)   dp[0][j] = false;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j] || j-nums[i-1]>=0 && dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][sum];
    }
}