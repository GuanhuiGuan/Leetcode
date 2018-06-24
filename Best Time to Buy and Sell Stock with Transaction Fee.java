class Solution {
    public int maxProfit(int[] prices, int fee) {
        // dp, pay the fee when a transaction happens(buy or sell, choose one)
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for(int price: prices) {
            int _dp0 = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, _dp0 - price - fee);
        }
        return dp0;
    }
}