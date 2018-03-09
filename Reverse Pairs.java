class Solution {
    public int reversePairs(int[] nums) {
        // mergesort and two pointers
        return mergeSort(nums, 0, nums.length-1);
    }
    
    public int mergeSort(int[] nums, int s, int e) {
        if(s >= e) return 0;
        int m = s + (e - s)/2;
        int sum = mergeSort(nums, s, m) + mergeSort(nums, m+1, e);
        
        for(int i = s, j = m+1; i <= m; i++) {
            while(j <= e && (nums[i]) > ((long)nums[j]*2)) j++;
            // m+1 --> j-1 is valid
            sum += (j-1) - (m+1) + 1;
        }
        
        // Arrays.sort(nums, s, e+1);
        merge(nums, s, e, m);
        return sum;
    }
    
    public void merge(int[] nums, int s, int e, int m) {
        // merge two sorted lists
        int[] temp = nums.clone();
        int i = s, j = m+1, k = s;
        while(i <= m && j <= e) {
            if(temp[i] < temp[j]) nums[k++] = temp[i++];
            else nums[k++] = temp[j++];
        }
        while(i <= m) nums[k++] = temp[i++];
        while(j <= e) nums[k++] = temp[j++];
    }
}