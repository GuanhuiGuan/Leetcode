class Solution {
    
    
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // DP; First record indices of left/right subarrays, and then try out index of middle subarray
        
        int[] res = new int[3];
        int maxSum = 0;
        int n = nums.length;
        Arrays.fill(res, -1);
        
        // Prepare sums
        int[] presum = new int[n+1];
        for(int i = 0; i < n; i++) {
            presum[i+1] = presum[i] + nums[i];
        }
        
        // Left subarray DP(sweeping right thus use >= for lexical order)
        int[] leftIndex = new int[n];
        // Init
        leftIndex[k-1] = 0;
        // DP(i is the end index of left subarray, skip case (0~k-1))
        for(int i = k, leftSum = presum[k] - presum[0]; i < n; i++) {
            int sum = presum[i+1] - presum[i-k+1];
            if(sum > leftSum) {
                leftSum = sum;
                leftIndex[i] = i-k+1;
            }
            else    leftIndex[i] = leftIndex[i-1];
        }
        
        // Right subarray DP(sweeping left thus use > for lexical order)
        int[] rightIndex = new int[n];
        // Init
        rightIndex[n-k] = n-k;
        // DP(i is the start index of right subarray, skip case(n-k, n-1))
        for(int i = n-k-1, rightSum = presum[n] - presum[n-k]; i >= 0; i--) {
            int sum = presum[i+k] - presum[i];
            if(sum >= rightSum) {
                rightSum = sum;
                rightIndex[i] = i;
            }
            else    rightIndex[i] = rightIndex[i+1];
        }
        
        // Try all middle subarray
        maxSum = 0;
        for(int i = k; i <= n - 2*k; i++) {
            // get left and right indices
            int li = leftIndex[i-1], ri = rightIndex[i+k];
            int sum = (presum[li+k] - presum[li]) + (presum[i+k] - presum[i]) + (presum[ri+k] - presum[ri]);
            if(sum > maxSum) {
                maxSum = sum;
                res[0] = li;
                res[1] = i;
                res[2] = ri;
            }
        }
        
        return res;
        
    }
}