class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0)  return false;
        int start = 0, end = n-1;
        while(start < end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) return true;
            
            // end->mid || start->mid+1, terminates when start==end
            // if not mono rise
            if(nums[mid] > nums[end]) {
                // front mono rise
                if(target < nums[mid] && target >= nums[start])  end = mid;
                else    start = mid+1;
            }
            // mono rise
            else if(nums[mid] < nums[end]) {
                // back mono rise
                if(target > nums[mid] && target <= nums[end])  start = mid+1;
                else    end = mid;
            }
            // duplicates: shrink
            else    end--;
        }
        return nums[start] == target;
    }
}