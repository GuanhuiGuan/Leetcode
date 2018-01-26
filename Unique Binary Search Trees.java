class Solution {
    public int numTrees(int n) {
        // dp as #uniBST for n nodes
        // dp[n] = sum_for_i(dp[i-1]*dp[n-i])
        if(n == 0 || n == 1)  return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            // j means pick the 1->i-th node as root
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}