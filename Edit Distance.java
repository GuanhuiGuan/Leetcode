class Solution {
    public int minDistance(String word1, String word2) {
        // DP, dp[i][j] means minimum number of steps to transform word1[0->i-1] to word2[0->j-1]
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        
        // Corner cases: dp[i][0] or dp[j][0] at least i or j deletions to transform to ""
        for(int i = 0; i <= m; i++)  dp[i][0] = i;
        for(int j = 0; j <= n; j++)  dp[0][j] = j;
        
        for(int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i-1);
            for(int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j-1);
                // If c1 == c2, same as dp[i-1][j-1]
                if(c1 == c2)    dp[i][j] = dp[i-1][j-1];
                // Else, min among replace, deletion, insertion
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}