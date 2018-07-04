class Solution {
    public int numDecodings(String s) {
        // Cannot start with '0'
        if(s == null || s.length() == 0 || s.charAt(0) == '0')    return 0;
        int n = s.length();
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*'? 9: 1;
        
        // Sweep every pair
        for(int i = 1; i < n; i++) {
            char c1 = s.charAt(i-1), c2 = s.charAt(i);
            
            // Single(c2 == 0 is an invalid single)
            dp[i+1] += (c2 == '*'? 9: (c2 == '0'? 0: 1)) * dp[i];
            
            // Pair
            if(c1 == '*') {
                if(c2 == '*')   dp[i+1] += (9+6) * dp[i-1];
                else    dp[i+1] += (c2 > '6'? 1: 2) * dp[i-1];
            }
            else if(c1 == '1' || c1 == '2') {
                if(c2 == '*')   dp[i+1] += (c1 == '1'? 9: 6) * dp[i-1];
                else {
                    int v = (c1 - '0')*10 + c2 - '0';
                    if(v > 0 && v < 27) dp[i+1] += dp[i-1];
                }
            }
            dp[i+1] %= 1000000007;
        }
        
        return (int)(dp[n]);
    }
}