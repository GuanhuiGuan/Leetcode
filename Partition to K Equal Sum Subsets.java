class Solution {
    int[] used;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums)  sum += num;
        if(k <= 0 || sum%k != 0)    return false;
        sum /= k;
        used = new int[nums.length];
        
        return dfs(nums, k, 0, 0, sum, 0);
    }
    
    // use start to improve runtime: won't go back, avoid duplicates
    public boolean dfs(int[] nums, int k, int cur_sum, int cur_num, int target, int start) {
        if(k == 1)  return true;
        if(cur_sum == target && cur_num > 0)    return dfs(nums, k-1, 0, 0, target, 0);
        if(cur_sum > target)    return false;
        
        for(int i = start; i < nums.length; i++) {
            if(used[i] == 0) {
                used[i] = 1;
                boolean next = dfs(nums, k, cur_sum+nums[i], cur_num+1, target, i+1);
                used[i] = 0;
                if(next)    return true;
            }
        }
        return false;
    }
}