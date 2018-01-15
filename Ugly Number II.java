class Solution {
    public int nthUglyNumber(int n) {
        // ugly nums are generated from smaller ugly nums, try their products and find min
        int[] dp = new int[n];
        dp[0] = 1;
        // indices
        int m2 = 0, m3 = 0, m5 = 0;
        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[m2]*2, Math.min(dp[m3]*3, dp[m5]*5));
            // increment indices if they're used
            if(dp[i] == dp[m2]*2)   m2++;
            if(dp[i] == dp[m3]*3)   m3++;
            if(dp[i] == dp[m5]*5)   m5++;
        }
        return dp[n-1];
    }
}