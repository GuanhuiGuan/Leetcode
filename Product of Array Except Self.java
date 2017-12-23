class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] out = new int[n];
        out[0] = 1;
        
        // forward
        for(int i = 1; i < n; i++){
            out[i] = out[i-1]*nums[i-1];
        }
        // backward
        int tail = 1;
        for(int i = n-1; i >= 0; i--){
            out[i] *= tail;
            tail *= nums[i];
        }
        
        return out;
    }
}