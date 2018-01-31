class Solution {
    // reservoir sampling
    int[] nums;
    Random r = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count = 0, re = -1;
        for(int i = 0; i < nums.length; i++) {
            if(target == nums[i]) {
                if(re < 0)  re = i;
                else {
                    // count exclude the current one
                    int next = r.nextInt(count+1);
                    if(next == count)   re = i;
                }
                // increment after update
                count++;
            }
        }
        return re;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */