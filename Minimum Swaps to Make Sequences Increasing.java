class Solution {
    public int minSwap(int[] A, int[] B) {
        // DP, keep two counts and sweep
        
        // swapCur: acc. swaps if swap current pair
        // keepCur: acc. swaps if keep current pair
        int swapCur = 1, keepCur = 0;
        for(int i = 1; i < A.length; i++) {
            // If shouldn't swap
            if(A[i] <= B[i-1] || B[i] <= A[i-1]) {
                // If swap i, then i-1 should swap too
                swapCur++;
                // keepCur stays the same
            }
            // A[i] > B[i-1] && B[i] > A[i-1], should swap
            else if(A[i] <= A[i-1] || B[i] <= B[i-1]) {
                // Swap prev swapCur and keepCur
                // If swap i, i-1 no need to swap; vice versa
                int t = swapCur;
                swapCur = keepCur + 1;
                keepCur = t;
            }
            // A[i] > B[i-1] && B[i] > A[i-1] && A[i] > A[i-1] && B[i] > B[i-1], swap or not would be fine
            else {
                // Take the min value
                int min = Math.min(swapCur, keepCur);
                swapCur = min + 1;
                keepCur = min;
            }
        }
        return Math.min(swapCur, keepCur);
    }
}