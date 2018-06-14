class Solution {
    public boolean increasingTriplet(int[] nums) {
        int check1 = Integer.MAX_VALUE, check2 = Integer.MAX_VALUE;
        for(int num: nums) {
            if(num <= check1)   check1 = num;
            else if(num <= check2)  check2 = num;
            else    return true;
        }
        return false;
    }
}