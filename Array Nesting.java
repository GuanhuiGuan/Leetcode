class Solution {
    public int arrayNesting(int[] nums) {
        int re = 0;
        
        // find cycle starting from each num
        for(int i = 0; i < nums.length; i++) {
            int cycle = 0;
            // mark those visited -1 so you won't revisit
            for(int k = i; nums[k] >= 0; cycle++) {
                int tmp = nums[k];
                nums[k] = -1;
                k = tmp;
            }
            // update max
            re = Math.max(re, cycle);
        }
        return re;
    }
}