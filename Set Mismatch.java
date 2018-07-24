class Solution {
    public int[] findErrorNums(int[] nums) {
        // Negate in first walk, the one already negated is the duplicate
        // Second walk, the positive one is the neglected
        int[] res = new int[2];
        
        for(int num: nums) {
            int index = Math.abs(num) - 1;
            if(nums[index] < 0)   res[0] = Math.abs(num);
            else    nums[index] *= -1;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                res[1] = i+1;
                break;
            }
        }
        return res;
    }
}