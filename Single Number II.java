class Solution {
    public int singleNumber(int[] nums) {
        // one and two are bits, 00, 01, 10 to represent 0, 1, 2, 3(0) apprearances
        int one = 0, two = 0;
        for(int n: nums){
            // if bit in two is 1, then bit in one must be 0; vice versa
            one = (one^n) & (~two);
            two = (two^n) & (~one);
        }
        return one;
    }
}