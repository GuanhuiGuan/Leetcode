class Solution {
    public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n+1][2];
//         dp[0][1] = Integer.MIN_VALUE;
        
//         for(int i = 0; i < n; i++) {
//             dp[i+1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
//             dp[i+1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
//         }
        
//         return dp[n][0];
        return lessSpace(prices);
    }

    public int lessSpace(int[] prices) {
        // 0 means no stock is left, 1 means having one stock held
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            int _dp0 = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, _dp0 - prices[i]);
        }
        // selling is always better at the end
        return dp0;
    }
}