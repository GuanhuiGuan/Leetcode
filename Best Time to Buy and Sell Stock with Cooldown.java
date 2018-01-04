class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        // i-2: rest before buy; i-1: buy before sell
        // buy[i] = max(sell[i-2]-p[i], buy[i-1]);
        // sell[i] = max(buy[i-1]+p[i], sell[i-1]);
        
        int b0 = Integer.MIN_VALUE, b1 = Integer.MIN_VALUE, s0 = 0, s1 = 0;
        for(int p: prices){
            b0 = b1;
            b1 = Math.max(s0-p, b0);
            s0 = s1;
            s1 = Math.max(b0+p, s0);
        }
        return s1;
    }
}