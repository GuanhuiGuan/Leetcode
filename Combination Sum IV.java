class Solution {
    public int combinationSum4(int[] nums, int target) {
        // DP, find num of combinations for each dp target from 0 -> target
        // return topDown(nums, target);
        return bottomUp(nums, target);
    }
    
    
    int[] dp;
    
    public int topDown(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        Arrays.sort(nums);
        return td(nums, target);
    }
    
    public int td(int[] nums, int target) {
        if(dp[target] != -1)    return dp[target];
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(target - nums[i] >= 0)   sum += td(nums, target - nums[i]);
        }
        dp[target] = sum;
        return sum;
    }
    
    public int bottomUp(int[] nums, int target) {
        int[] counts = new int[target + 1];
        Arrays.sort(nums);
        counts[0] = 1;
        
        // tt = temp target
        for(int tt = 1; tt <= target; tt++) {
            for(int i = 0; i < nums.length; i++) {
                if(tt - nums[i] >= 0)   counts[tt] += counts[tt - nums[i]];
            }
        }
        return counts[target];
    }
}