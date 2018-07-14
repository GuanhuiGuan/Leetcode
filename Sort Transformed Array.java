class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        // Depends on a > 0(two ends to center) or a < 0(center to two ends)
        // If a == 0, still can be going from both ends by comparing
        int n = nums.length;
        int[] res = new int[n];
        
        int i = 0, j = n-1;
        int index = (a >= 0)? n-1: 0;
        while(i <= j) {
            if(a >= 0)  res[index--] = polynomial(nums[i], a, b, c) > polynomial(nums[j], a, b, c) ?
                polynomial(nums[i++], a, b, c): polynomial(nums[j--], a, b, c);
            else    res[index++] = polynomial(nums[i], a, b, c) < polynomial(nums[j], a, b, c) ?
                polynomial(nums[i++], a, b, c): polynomial(nums[j--], a, b, c);
        }
        return res;
    }
    
    private int polynomial(int num, int a, int b, int c) {
        return a*num*num + b*num + c;
    }
}