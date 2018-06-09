class Solution {
    public int numDecodings(String s) {
        // init
        if(s == null || s.length() == 0 || s.charAt(0) == '0')    return 0;
        int n = s.length();
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*'? 9: 1;
        
        // DP
        for(int i = 2; i <= n; i++) {
            char fst = s.charAt(i-2), snd = s.charAt(i-1);
            
            // single char
            if(snd == '*')  dp[i] += 9*dp[i-1];
            else if(snd > '0')  dp[i] += dp[i-1];
            
            // pair chars(fst can only be *, 1, 2)
            if(fst == '*') {
                // 1/2+*, 1/2+(0~6), 1+(7~9)
                if(snd == '*')  dp[i] += (9+6) * dp[i-2];
                else if(snd < '7') dp[i] += 2 * dp[i-2];
                else    dp[i] += dp[i-2];
            }
            else if(fst == '1' || fst == '2') {
                // 1*, 2*
                if(snd == '*') {
                    if(fst == '1')  dp[i] += 9 * dp[i-2];
                    else    dp[i] += 6 * dp[i-2];
                }
                // 1/2+()
                else if(valid(fst, snd))    dp[i] += dp[i-2];
            }
            dp[i] %= 1000000007;
        }
        return (int)dp[n];
    }
    
    public boolean valid(char fst, char snd) {
        int num = (fst - '0') * 10 + snd - '0';
        return num > 0 && num <= 26;
    }
}