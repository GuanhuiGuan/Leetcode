class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // partition nums1 and nums2 into left(nums1[:i-1], nums2[:j-1]) and right(nums1[i:], nums2[j:])
        // median is between left_max and right_min or just left_max
        int m = nums1.length, n = nums2.length;
        // assume m <= n
        if(m > n) return findMedianSortedArrays(nums2, nums1);
        
        // binary search on nums1
        // half_all is set so that j = half_all - i == the first index on right side
        int i_lo = 0, i_hi = m, half_all = (m + n + 1) / 2;
        int i = 0, j = 0;
        double left_max = 0, right_min = 0;
        
        while(i_lo <= i_hi) {
            // nums1[i-1] <= nums2[j], nums2[j-1] <= nums[i]
            i = i_lo + (i_hi - i_lo) / 2;
            j = half_all - i;
            
            if(i > 0 && nums1[i-1] > nums2[j]) i_hi = i - 1;
            else if(i < m && nums2[j-1] > nums1[i]) i_lo = i + 1;
            else {
                // we found the i
                
                break;
            }
        }
        // find max on the left group
        if(i == 0) left_max = (double)nums2[j-1];
        else if(j == 0) left_max = (double)nums1[i-1];
        else left_max = (double)Math.max(nums1[i-1], nums2[j-1]);
        
        // if odd total length, median falls to left_max
        if((m + n) % 2 == 1) return left_max;

        // find right group min
        if(i == m) right_min = (double)nums2[j];
        else if(j == n) right_min = (double)nums1[i];
        else right_min = (double)Math.min(nums1[i], nums2[j]);
        
        
        
        return (left_max + right_min) / 2;
    }
}