class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        
        if(n == 0)  return 0;
        // empty string
        dp[n] = 1;
        // 1 character
        if(s.charAt(n-1) == '0'){
            dp[n-1] = 0;
        }
        else{
            dp[n-1] = 1;
        }
        // backwards
        for(int i = n-2; i >= 0; i--){
            // skip those start with 0, cause it can't be decoded
            if(s.charAt(i) == '0')  continue;
            // substring <= 26, two way, otherwise one way
            dp[i] = (Integer.parseInt(s.substring(i, i+2)) <= 26) ?
                dp[i+1] + dp[i+2] : dp[i+1];
        }
        
        
        return dp[0];
    }
}