class Solution {
    int[] used;
    
    public int findMaxForm(String[] strs, int m, int n) {
        // dp backpack?
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        
        for(int k = 1; k <= strs.length; k++) {
            int[] zo = get01(strs[k-1]);
            for(int i = 0; i <= m; i++) {
                for(int j = 0; j <= n; j++) {
                    if(zo[0] <= i && zo[1] <= j) {
                        dp[k][i][j] = Math.max(dp[k-1][i-zo[0]][j-zo[1]] + 1, dp[k-1][i][j]);
                    }
                    else    dp[k][i][j] = dp[k-1][i][j];
                }
            }
        }
        return dp[strs.length][m][n];
    }
    
    public int[] get01(String s) {
        int[] re = new int[2];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0')  re[0]++;
            else    re[1]++;
        }
        return re;
    }
}