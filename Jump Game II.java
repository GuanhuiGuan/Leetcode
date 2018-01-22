class Solution {
    public int jump(int[] nums) {
        // BFS and Greedy
        int n = nums.length;
        if(n < 2)   return 0;
        int i = 0, curReach = 0, nextReach = 0, lvl = 0;
        
        while(curReach - i >= 0) {  // #nodes on this lvl > 0
            lvl++;
            for(; i <= curReach; i++) {
                nextReach = Math.max(nextReach, nums[i]+i);
                if(nextReach >= n-1)    return lvl;
            }
            curReach = nextReach;
        }
        return -1;
    }
}