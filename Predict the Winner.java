class Solution {
    public boolean PredictTheWinner(int[] nums) {
        // DP solution, save points cur player MORE than opponent
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        // fill the diagonal, only 1 to choose
        for(int i = 0; i < n; i++)  dp[i][i] = nums[i];
        // start from small lengths
        for(int len = 1; len < n; len++) {
            for(int i = 0; i+len < n; i++) {
                int j = i+len;
                dp[i][j] = Math.max(nums[i] - dp[i+1][j],
                                    nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}