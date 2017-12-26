class Solution {
    int target;
    int[] visited;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        if(sum%k != 0)  return false;
        target = sum/k;
        visited = new int[nums.length];
        return helper(nums, k, 0, 0, 0);
    }
    
    public boolean helper(int[] nums, int k, int curSum, int curNum, int start){
        if(k == 1)  return true;
        // cur partition works -> goes to next partition(start at 0, visited kept)
        if(curSum == target && curNum > 0){
            return helper(nums, k-1, 0, 0, 0);
        }
        // iterate the list for unvisited ones(from start)
        for(int i = start; i < nums.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                // start from i+1(all before are visited); curNum increases
                if(helper(nums, k, curSum+nums[i], curNum+1, i+1))   return true;
                visited[i] = 0;
            }
        }
        return false;
    }
}