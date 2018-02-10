class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for(int num: nums) {
            if(num == 1) {
                count++;
            }
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        // remember the ending corner case
        max = Math.max(max, count);
        return max;
    }
}