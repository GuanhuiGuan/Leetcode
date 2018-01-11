class Solution {
    public int minCostII(int[][] costs) {
        // 2 indices pointing to min and second min cost
        int min0 = -1, min1 = -1;
        int n = costs.length;
        if(n == 0)  return 0;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        
        for(int i = 0; i < n; i++) {
            int m0 = min0, m1 = min1;
            min0 = -1;
            min1 = -1;
            
            for(int j = 0; j < k; j++) {
                // update sums
                if(j != m0) {
                    // first iteration
                    if(m0 < 0)  dp[i][j] = costs[i][j];
                    else    dp[i][j] = dp[i-1][m0] + costs[i][j];
                }
                else {
                    // first iteration
                    if(m1 < 0)  dp[i][j] = costs[i][j];
                    else    dp[i][j] = dp[i-1][m1] + costs[i][j];
                }
                
                // update min indices
                if(min0 < 0 || dp[i][j] < dp[i][min0]) {
                    min1 = min0;
                    min0 = j;
                }
                else if(min1 < 0 || dp[i][j] < dp[i][min1]) {
                    min1 = j;
                }
            }
        }
        return dp[n-1][min0];
    }
}