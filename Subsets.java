class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        // Arrays.sort(nums);
        res.add(new ArrayList<>());
        bt(nums, 0, new ArrayList<>());
        return res;
    }
    
    public void bt(int[] nums, int start, List<Integer> list) {
        if(!list.isEmpty()) res.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            bt(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}