class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // still dp, but added swap min and max
        // multiply a negative would make small large and large small
        int re = nums[0];
        
        for(int i = 1, small = re, large = re; i < nums.length; i++){
            if(nums[i] < 0){
                int t = small;
                small = large;
                large = t;
            }
            // similar to max subarray sum
            small = Math.min(small*nums[i], nums[i]);
            large = Math.max(large*nums[i], nums[i]);
            
            re = Math.max(re, large);
        }
        
        return re;
    }
}