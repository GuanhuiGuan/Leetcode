class Solution {
    public int splitArray(int[] nums, int m) {
        // Binary search: max among nums <= res <= sum of nums
        
        // Get max and sum
        int max = 0;
        long sum = 0;
        for(int num: nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if(m == 1)  return (int)sum;
        
        // Binary search
        long left = max, right = sum;
        // Even if same, still have to test if such params can be split, thus <=
        while(left <= right) {
            long mid = left + (right - left) / 2;
            // can split: mid too large
            if(canSplit(nums, m, mid))  right = mid - 1;
            // else: has to make it to be able to split by enlarging mid
            else    left = mid + 1;
        }
        return (int)left;
    }
    
    // Determine whether nums can be split into m arrays with each sum <= target
    public boolean canSplit(int[] nums, int m, long target) {
        long sum = 0;
        int arrays = 1; // at least one array
        for(int num: nums) {
            sum += num;
            if(sum > target) {
                sum = num;
                arrays++;
                if(arrays > m)  return false;
            }
        }
        return true;
    }
}