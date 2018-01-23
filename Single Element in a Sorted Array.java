class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while(lo < hi) {
            // find the 1st element of middle two nums
            int mid = lo + (hi-lo)/2;
            if(mid%2 == 1)  mid--;
            
            // if mid 2 nums are pairs, front must be even length, thus at the back
            if(nums[mid] == nums[mid+1])    lo = mid+2;
            // if mid 2 nums are not pairs, front(include mid) is odd, must be in the front
            else    hi = mid;
        }
        return nums[lo];
    }
}