class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        // double loop
        // iterate reversely, the max edge at the back
        for(int i = nums.length-1; i > 1; i--) {
            int lo = 0, hi = i-1;
            while(lo < hi) {
                if(nums[lo] + nums[hi] > nums[i]) {
                    count += hi-lo;
                    hi--;
                }
                else    lo++;
            }
        }
        return count;
    }
}