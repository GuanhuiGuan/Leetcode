class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[nums[i]-1] != nums[i]) {
                swap(nums, nums[i]-1, i);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] != i+1)  list.add(i+1);
        }
        return list;
    }
    
    public void swap(int[] nums, int x1, int x2) {
        int t = nums[x1];
        nums[x1] = nums[x2];
        nums[x2] = t;
    }
}