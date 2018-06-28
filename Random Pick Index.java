class Solution {
    Random rand = new Random();
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    //** Reservoir Sampling, the length is the number of target met on the sweep */
    public int pick(int target) {
        int res = -1, reservoirLen = 0;
        for(int i = 0; i < nums.length; i++) {
            if(target == nums[i]) {
                // If first one, assign value
                if(res < 0) res = i;
                // Otherwise, randomly draw one out of the reservoir(those targets met)
                // If it's the current one, swap
                else if(rand.nextInt(reservoirLen+1) == reservoirLen)   res = i;
                // Remember to increment the reservoir length
                reservoirLen++;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */