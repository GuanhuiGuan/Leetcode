class Solution {
    public int[] twoSum(int[] nums, int target) {
        // use hashmap to save a pair, whose sum is the target
        Map<Integer, Integer> hm = new HashMap<>();
        int[] out = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])){
                out[0] = hm.get(nums[i]);
                out[1] = i;
                return out;
            }
            hm.put(target - nums[i], i);
        }
        return out;
    }
}