class Solution {
    public int wiggleMaxLength(int[] nums) {
        // greedy
        // first avoid duplicates at the start, then find every peak and valley
        if(nums.length < 2) return nums.length;
        int i = 1;
        while(i < nums.length && nums[i-1] == nums[i])  i++;
        if(i == nums.length)    return 1;
        
        int max = 2;
        boolean rise = (nums[i-1] < nums[i]);
        for(i = i+1; i < nums.length; i++) {
            if(rise) {
                if(nums[i] < nums[i-1]) {
                    max++;
                    rise = false;
                }
            }
            else {
                if(nums[i] > nums[i-1]) {
                    max++;
                    rise = true;
                }
            }
        }
        return max;
    }
}