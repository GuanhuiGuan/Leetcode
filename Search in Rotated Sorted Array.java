class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        // binary search
        if(n == 0)    return -1;
        // find min
        int start = 0, end = n - 1;
        while(start < end){
            int mid = (start + end)/2;
            // if mid greater, min cannot be mid, and thus move 1 step beyond
            if(nums[mid] > nums[end]) start = mid + 1;
            //could be mid here
            else    end = mid;
        }
       
        int rotation = start;
        
        // rotate the mid
        start = 0;
        end = nums.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            int rotMid = (mid+rotation)%n;
            if(target == nums[rotMid])  return rotMid;
            else if(target < nums[rotMid]) end = mid - 1;
            else    start = mid + 1;
        }
        return -1;
    }
}