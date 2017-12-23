class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // use backtracking
        List<List<Integer>> lists = new ArrayList<>();
        bt(lists, new ArrayList<>(), nums);
        return lists;
    }
    
    public void bt(List<List<Integer>> lists, List<Integer> list, int[] nums){
        // remember to add(new ArrayList<>(list))
        if(list.size() == nums.length)  lists.add(new ArrayList<>(list));
        
        for(int i = 0; i < nums.length; i++){
            // use contains to find used ones
            if(list.contains(nums[i]))  continue;
            list.add(nums[i]);
            bt(lists, list, nums);
            list.remove(list.size()-1);
        }
    }
}
