class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        
        int ns = s.length(), np = p.length();
        boolean[][] dp = new boolean[ns+1][np+1];
        // both empty || p being a*b*c*...
        dp[0][0] = true;
        for(int j = 0; j < np; j++) {
            // dp[0][j-1] --> p.charAt(j-2)
            if(p.charAt(j) == '*' && dp[0][j-1]) {
                dp[0][j+1] = true;
            }
        }
        
        for(int i = 0; i < ns; i++) {
            for(int j = 0; j < np; j++) {
                if(isEqual(s.charAt(i), p.charAt(j)))   dp[i+1][j+1] = dp[i][j];
                else if(j != 0 && p.charAt(j) == '*') {
                    // a*
                    if(!isEqual(s.charAt(i), p.charAt(j-1)))    dp[i+1][j+1] = dp[i+1][j-1]; // 0 a
                    else {
                        dp[i+1][j+1] = dp[i][j+1] // multiple a
                            || dp[i+1][j] // one a
                            || dp[i+1][j-1]; // 0 a
                    }
                }
            }
        }
        return dp[ns][np];
    }
    
    public boolean isEqual(char cs, char cp) {
        return cs == cp || cp == '.';
    }
}