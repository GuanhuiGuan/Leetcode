class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        if(sum%2 != 0)  return false;
        int target = sum/2;
        
        boolean[][] dp = new boolean[nums.length+1][target+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], false);
        }
        dp[0][0] = true;
        
        for(int i = 1; i <= nums.length; i++){
            for(int j = target; j >= 0; j--){
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1]){
                    // pick it or not pick it
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}


// space optimized_______________

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        if(sum%2 != 0)  return false;
        int target = sum/2;
        
        
        boolean[] dp = new boolean[target+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= 0; j--){
                if(nums[i] <= j){
                    // not pick || pick
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        
        return dp[target];
    }
}