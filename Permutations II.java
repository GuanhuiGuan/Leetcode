class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int[] visited = new int[nums.length];
        // sort nums to let duplicates stay together
        Arrays.sort(nums);
        bt(nums, lists, new ArrayList<>(), visited);
        return lists;
    }
    
    public void bt(int[] nums, List<List<Integer>> lists, List<Integer> list, int[] visited){
        if(list.size() == nums.length){
            // SET UP NEW LIST!!
            lists.add(new ArrayList(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            // filter not-visited and first/not same as last one/same as last but last is in list
            if(visited[i] == 0 && (i == 0 || nums[i] != nums[i-1] || (nums[i] == nums[i-1] && visited[i-1] == 1))){
                visited[i] = 1;
                list.add(nums[i]);
                bt(nums, lists, list, visited);
                list.remove(list.size()-1);
                visited[i] = 0;
            }
        }
    }
}