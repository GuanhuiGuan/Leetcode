class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> re = new ArrayList<>();
        // every time value is read, nums[value] is marked negative
        for(int num: nums){
            int value = Math.abs(num) - 1;
            if(nums[value] > 0){
                nums[value] = -nums[value];
            }
        }
        // those positive are not marked in the first loop
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                re.add(i+1);
            }
        }
        return re;
    }
}