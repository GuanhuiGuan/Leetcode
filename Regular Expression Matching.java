class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() > 0 && p.charAt(0) == '*')   return false;
        
        // dp[i][j]: substring(0, i-1), substring(0, j-1) match
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        for(int i = 0; i <= s.length(); i++)    Arrays.fill(dp[i], false);
        
        dp[0][0] = true;
        // 2k+1 == '*': can skip to 2 steps ahead
        for(int j = 1; j < p.length(); j+=2){
            if(p.charAt(j) == '*'){
                dp[0][j+1] = dp[0][j-1];
            }
        }
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                // not asterisk
                if(p.charAt(j-1) != '*'){
                    dp[i][j] = dp[i-1][j-1] && eq(s.charAt(i-1), p.charAt(j-1));
                }
                // is asterisk
                else{
                    // not use asterisk || use asterisk if *prev == s[i-1]
                    dp[i][j] = dp[i][j-2] || (eq(s.charAt(i-1), p.charAt(j-2)) && dp[i-1][j]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    
    public boolean eq(char c1, char c2){
        return c1 == c2 || c2 == '.';
    }
}