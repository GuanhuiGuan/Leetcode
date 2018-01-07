class Solution {
    public int missingNumber(int[] nums) {
        int s = nums.length;
        for(int i = 0; i < nums.length; i++) {
            s ^= i ^ nums[i];
        }
        return s;
    }
}