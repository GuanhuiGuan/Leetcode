class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length, lo = 0, hi = n-1;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target) return true;
            
            // find which part is sorted
            // front is sorted
            if(nums[mid] > nums[hi]) {
                if(target >= nums[lo] && target < nums[mid])    hi = mid-1;
                else    lo = mid+1;
            }
            // back is sorted
            else if(nums[mid] < nums[hi]){
                if(target > nums[mid] && target <= nums[hi])    lo = mid+1;
                else    hi = mid-1;
            }
            else    hi--; // nums[mid] == nums[lo] == nums[hi]
        }
        return false;
    }
}