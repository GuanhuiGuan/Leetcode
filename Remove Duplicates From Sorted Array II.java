class Solution {
    public int removeDuplicates(int[] nums) {
        // simpler version, s points to the end of the correct array
        int s = -1;
        for(int i = 0; i < nums.length; i++) {
            if(s < 1 || nums[i] > nums[s-1]) {
                nums[++s] = nums[i];
            }
        }
        return s+1;
        
        // Map<Integer, Integer> map = new HashMap<>();
        // int s = -1;
        // for(int i = 0; i < nums.length; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        //     if(map.get(nums[i]) > 2)   continue;
        //     // otherwise, swap
        //     s++;
        //     swap(nums, s, i);
        // }
        // return s+1;
    }
    
    public void swap(int[] nums, int s, int i) {
        int t = nums[s];
        nums[s] = nums[i];
        nums[i] = t;
    }
}