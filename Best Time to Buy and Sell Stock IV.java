class Solution {
    public int maxProfit(int k, int[] prices) {
        // at most n/2 transactions can be made
        // if k >= n/2, then k is no longer a limit
        int n = prices.length;
        if(k >= n/2) {
            int dp0 = 0, dp1 = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                int _dp0 = dp0;
                dp0 = Math.max(dp0, dp1 + prices[i]);
                dp1 = Math.max(dp1, _dp0 - prices[i]);
            }
            return dp0;
        }
        
        // count a transaction at buy
        int[] dpk0 = new int[k+1], dpk1 = new int[k+1];
        Arrays.fill(dpk1, Integer.MIN_VALUE);
        for(int i = 0; i < n; i++) {
            for(int j = k; j > 0; j--) {
                dpk0[j] = Math.max(dpk0[j], dpk1[j] + prices[i]);
                dpk1[j] = Math.max(dpk1[j], dpk0[j-1] - prices[i]);
            }
        }
        return dpk0[k];
    }
}