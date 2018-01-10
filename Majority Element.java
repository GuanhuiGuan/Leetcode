class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        // assume major, reset major when count==0, count++ if equal, count-- if not
        int major = nums[0], count = 1;
        for(int i = 1; i < n; i++) {
            // reset major
            if(count == 0) {
                major = nums[i];
                count++;
            }
            else if(major != nums[i])   count--;
            else    count++;
        }
        return major;
    }
}