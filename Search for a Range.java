class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0)  return new int[] {-1, -1};
        
        int start = 0, end = n-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                int[] range = expand(nums, target, mid);
                return range;
            }
            if(nums[mid] < target)  start = mid+1;
            else    end = mid-1;
        }
        
        return new int[] {-1, -1};
    }
    
    public int[] expand(int[] nums, int target, int mid){
        int start = mid, end = mid;
        while(start >= 0 && nums[start] == target)  start--;
        while(end < nums.length && nums[end] == target)  end++;
        int[] range = new int[] {start+1, end-1};
        return range;
    }
}