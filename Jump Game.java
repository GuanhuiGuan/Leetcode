class Solution {
    public boolean canJump(int[] nums) {
        // one pass O(n), find max reach of each index, check the stop index
        int pos = 0, maxReach = 0;
        for(; pos < nums.length && pos <= maxReach; pos++) {
            maxReach = Math.max(maxReach, pos+nums[pos]);
        }
        // check if reach the end
        return pos == nums.length;
        
//         // dp O(n^2)
//         int n = nums.length;
//         if(n == 0)  return false;
//         boolean[] dp = new boolean[n];
//         dp[n-1] = true;
        
//         for(int i = n-2; i >= 0; i--) {
//             int next = nums[i] + i; // max position to arrive
//             if(next >= n)   dp[i] = true;
//             else {
//                 dp[i] = false;
//                 for(int j = next; j > i; j--) {
//                     dp[i] |= dp[j];
//                     if(dp[i])   break;
//                 }
//             }
//         }
//         return dp[0];
    }
}