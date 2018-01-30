class Solution {
    int[][] dp;
    
    // DP and minmax
    public int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        return DP(1, n);
    }
    
    public int DP(int s, int e) {
        if(s >= e)  return 0;
        if(dp[s][e] != 0)   return dp[s][e];
        
        // find min for all splitting options
        int min = Integer.MAX_VALUE;
        for(int i = s; i <= e; i++) {
            // find max/worst outcome for every split
            int max = Math.max(DP(s, i-1), DP(i+1, e)) + i;
            min = Math.min(min, max);
        }
        dp[s][e] = min;
        return min;
    }
}