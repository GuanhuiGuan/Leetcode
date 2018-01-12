class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        // dp[i]: actions with i 'A's
        // search previous ones can be floor divided
        for(int i = 2; i <= n; i++) {
            // worst case
            dp[i] = i;
            for(int j = i-1; j > 0; j--) {
                // find the largest factor
                if(i%j==0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }
            }
        }
        return dp[n];
    }
}