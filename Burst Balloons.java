class Solution {
    public int maxCoins(int[] nums) {
        // DP; Think reversely, starting from bursting the last one
        
        // Modify array
        int[] _nums = new int[nums.length+2];
        int n = _nums.length;
        // Corner cases: 1
        _nums[0] = 1;
        _nums[n-1] = 1;
        // Fill others
        for(int i = 0; i < nums.length; i++)  _nums[i+1] = nums[i];
        
        int[][] dp = new int[n][n];
        for(int len = 2; len < n; len++) {
            for(int left = 0; left < n-len; left++) {
                int right = left + len;
                // Left and right bounds, not used as i
                for(int i = left+1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], 
                                               _nums[i]*_nums[left]*_nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        
        return dp[0][n-1];
    }
}