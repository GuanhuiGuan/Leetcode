class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0)  return 0;
        if(n == 1)  return nums[0];
        // 0->n-2, 1->n-1
        int[] dp = new int[n];
        
        dp[1] = nums[0];
        for(int i = 1; i < n-1; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
        }
        int temp = dp[n-1];
        
        Arrays.fill(dp, 0);
        dp[1] = nums[1];
        for(int i = 1; i < n-1; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i+1]);
        }
        return Math.max(temp, dp[n-1]);
    }
}