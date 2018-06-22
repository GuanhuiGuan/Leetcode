class Solution {
    public int maxProfit(int[] prices) {
        // at most 2 transactions
        // dpij --> i: num of transaction; j: state of stock
        // transaction is only counted at buy
        int dp10 = 0, dp11 = Integer.MIN_VALUE, dp20 = 0, dp21 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            dp20 = Math.max(dp20, dp21 + prices[i]);
            dp21 = Math.max(dp21, dp10 - prices[i]);
            dp10 = Math.max(dp10, dp11 + prices[i]);
            dp11 = Math.max(dp11, 0 - prices[i]);
        }
        return dp20;
    }
}