class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int max = 0;
        
        
        // // 2D matrix, dp[i+1][j+1] meaning longest same subarray ending at A[i], B[j]
        // int[][] dp = new int[m+1][n+1];
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         dp[i+1][j+1] = A[i] == B[j] ? dp[i][j] + 1: 0;
        //         max = Math.max(dp[i+1][j+1], max);
        //     }
        // }
        
        // 1D array, going from backwards to utilize data from i-1
        int[] dp = new int[n+1];
        for(int i = 0; i < m; i++) {
            for(int j = n-1; j >= 0; j--) {
                dp[j+1] = A[i] == B[j] ? dp[j] + 1: 0;
                max = Math.max(dp[j+1], max);
            }
        }
        
        return max;
    }
}