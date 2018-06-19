class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0, len = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] > nums[i-1])   len++;
            else    len = 1;
            res = Math.max(res, len);
        }
        return res;
    }
}