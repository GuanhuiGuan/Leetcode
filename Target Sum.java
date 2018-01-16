class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // pos-neg=S, pos+neg+pos-neg=S+pos+neg, pos = (S+sum)/2
        int sum = 0;
        for(int num: nums)  sum += num;
        int target = (S+sum)/2;
        if(sum<S || (S+sum)%2 != 0)  return 0;
        
        // 0/1 knapsack modified
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int num: nums) {
            for(int i = target; i >= num; i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}