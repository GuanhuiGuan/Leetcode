class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        return findTar(nums, target, findRot(nums));
    }
    
    public int findRot(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[high])  low = mid + 1;
            else    high = mid;
        }
        return low;
    }
    
    public int findTar(int[] nums, int target, int rot) {
        int low = 0, high = nums.length - 1, n = nums.length, rotMid = low;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            rotMid = getRotMid(rot, mid, n);
            if(nums[rotMid] == target) break;
            if(nums[rotMid] > target)   high = mid - 1;
            else    low = mid + 1;
        }
        return nums[rotMid] == target? rotMid: -1;
        // return nums[rotMid] < target? rotMid + 1: rotMid;
    }
    
    public int getRotMid(int rot, int mid, int n) {
        return (mid + rot) % n;
    }
}