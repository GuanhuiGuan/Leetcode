class Solution {
    public int maxProfit(int[] prices) {
        // cache dp one day earlier
        int dp0_pre = 0, dp0 = 0, dp1 = Integer.MIN_VALUE;
        for(int price: prices) {
            int _dp0 = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, dp0_pre - price);
            dp0_pre = _dp0;
        }
        return dp0;
    }
}