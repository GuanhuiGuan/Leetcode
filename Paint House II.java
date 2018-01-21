class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0)  return 0;
        int k = costs[0].length;
        int[][] dp = new int[n+1][k];
        
        // indices of min and 2nd-min; need in total 4 pointers, last round(last1, last2) and this round(m1, m2)
        int m1 = -1, m2 = -1;
        for(int i = 0; i < n; i++) {
            // new and reset
            int last1 = m1, last2 = m2;
            m1 = -1;
            m2 = -1;
            for(int j = 0; j < k; j++) {
                dp[i+1][j] += costs[i][j];
                // update dp, cautious about -1 ptr
                if(j == last1) {
                    if(last2 >= 0) dp[i+1][j] += dp[i][last2];
                }
                else{
                    if(last1 >= 0) dp[i+1][j] += dp[i][last1];
                }
                
                // update indices, initial force update
                if(m1<0 || dp[i+1][j] < dp[i+1][m1]) {
                    m2 = m1;
                    m1 = j;
                }
                else if(m2<0 || dp[i+1][j] < dp[i+1][m2]) {
                    m2 = j;
                }
            }
        }
        return dp[n][m1];
    }
}