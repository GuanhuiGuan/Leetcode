class Solution {
    public int maxA(int N) {
        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++) {
            dp[i] = i;
            for(int j = 1; j <= i-3; j++) {
                // i-j actions left, 2 for ctrlA, ctrlC, plus the original copy
                dp[i] = Math.max(dp[i], dp[j]*(i-j-2+1));
            }
        }
        return dp[N];
    }
}