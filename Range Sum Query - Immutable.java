class NumArray {
    // sum of all elements up to this point
    int[] sum;

    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n];
        for(int i = 0; i < n; i++){
            sum[i] = nums[i] + (i==0? 0: sum[i-1]);
        }
    }
    
    public int sumRange(int i, int j) {
        return i==0? sum[j]: (sum[j] - sum[i-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */