class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)    return 0;
        int n = s.length();
        
        // DP from the tail
        // init state
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = s.charAt(n-1) == '0'? 0: 1;
        
        // usual DP
        for(int i = n-2; i >= 0; i--) {
            // cannot start with 0 for a pair
            if(s.charAt(i) == '0')  continue;
            String sub = s.substring(i, i+2);
            dp[i] += valid(sub)? dp[i+1] + dp[i+2]: dp[i+1];
        }
        return dp[0];
    }
    
    public boolean valid(String s) {
        int num = Integer.parseInt(s);
        return (num > 0 && num < 27);
    }
}