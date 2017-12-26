class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length <= 0)   return false;
        if(n <= 0)  return true;
        
        // dp[i][j]: i slots, j flowers to plant
        boolean[][] dp = new boolean[flowerbed.length+1][n+1];
        for(int i = 0; i <= flowerbed.length; i++){
            Arrays.fill(dp[i], false);
            dp[i][0] = true;
        }
        if(flowerbed[0] == 0){
            dp[1][1] = true;
        }
            
        
        for(int i = 2; i <= flowerbed.length; i++){
            for(int j = 1; j <= n; j++){
                // point is empty
                if(flowerbed[i-1] == 0){
                    dp[i][j] = (dp[i-2][j-1] && flowerbed[i-2] == 0) || dp[i-1][j];
                }
                // point is not empty: has at least 1 gap
                else{
                    dp[i][j] = dp[i-2][j];
                }
            }
        }
        return dp[flowerbed.length][n];
    }
}