class Solution {
    public boolean canWinNim(int n) {
        // player to move win or lose with i stones left
        boolean[] dp = new boolean[4];
        Arrays.fill(dp, true);
        dp[0] = false;
        // for(int i = 4; i <= n; i++){
        //     dp[i%4] = ((!dp[(i-1)%4]) && (!dp[(i-2)%4]) && (!dp[(i-3)%4]));
        // }
        return dp[n%4];
    }
}