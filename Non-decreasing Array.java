class Solution {
    public boolean checkPossibility(int[] nums) {
        // Greedy, modify from front
        int n = nums.length, count = 0;
        
        for(int i = 1; i < n && count < 2; i++) {
            if(nums[i-1] > nums[i]) {
                count++;
                // Try to modify nums[i-1] to minimize effect on latter array
                if(i-2 < 0 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
                // Have to modify nums[i]
                else    nums[i] = nums[i-1];
            }
        }
        
        return count < 2;
    }
}