class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        
        for(int i = 0; i < nums.length-2; i++) {
            int right = target-nums[i];
            int j = i+1, k = nums.length-1;
            while(j < k) {
                if(nums[j] + nums[k] < right) {
                    count += k-j;  // those k < cur_k must meet such condition
                    j++;
                }
                else    k--;
            }
        }
        return count;
    }
}