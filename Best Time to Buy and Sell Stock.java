class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, acc = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            // decrease is also accounted, but the overall acc must be non-negative
            acc = Math.max(0, acc + prices[i+1] - prices[i]);
            max = Math.max(max, acc);
        }
        return max;
    }
}