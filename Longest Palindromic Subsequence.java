class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0)    return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        
        // // from short substring to long substring, that's why i reversed
        // for(int i = n-1; i >= 0; i--) {
        //     dp[i][i] = 1;
        //     for(int j = i+1; j < n; j++) {
        //         if(s.charAt(i)==s.charAt(j))    dp[i][j] = dp[i+1][j-1] + 2;
        //         else    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
        //     }
        // }
        
        // increment the substring length
        for(int i = 0; i < n; i++)  dp[i][i] = 1;
        
        for(int d = 1; d < n; d++) {
            for(int i = 0; i+d < n; i++) {
                int j = i+d;
                if(s.charAt(i)==s.charAt(j))    dp[i][j] = dp[i+1][j-1] + 2;
                else    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        return dp[0][n-1];
    }
}