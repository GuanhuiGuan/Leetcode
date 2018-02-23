package rotated;

public class SearchInRotated {
	public int search(int[] nums, int target) {
        // find min
        int start = 0, end = nums.length-1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[end])   start = mid+1;
            else    end = mid;
        }
        int rot = start;
        
        // adjusted binary search
        start = 0;
        end = nums.length-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            int rotMid = (mid+rot)%nums.length;
            if(nums[rotMid] == target)  return rotMid;
            if(nums[rotMid] > target)   end = mid-1;
            else    start = mid+1;
        }
        return (start+rot)%nums.length;
    }
}
