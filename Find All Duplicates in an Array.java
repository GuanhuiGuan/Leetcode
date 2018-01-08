class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        // negate each, check if it's already negative
        for(int i = 0; i < n; i++) {
            int ind = Math.abs(nums[i])-1;
            if(nums[ind] < 0) list.add(ind+1);
            nums[ind] *= -1;
        }
        return list;
    }
}