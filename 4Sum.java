class Solution {
    List<List<Integer>> re = new ArrayList<>();
    int[] used;
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        used = new int[nums.length];
        // dfs(nums, target, 4, 0, new ArrayList<>());
        kSum(nums, target, 4, 0, new ArrayList<>());
        return re;
    }
    
    public void kSum(int[] nums, int target, int k, int start, List<Integer> list) {
        if(k < 2)   return;
        
        if(k == 2) {
            int i = start, j = nums.length-1;
            while(i < j) {
                if(nums[i] + nums[j] == target) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    re.add(new ArrayList<>(list));
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    
                    while(i+1 < j && nums[i] == nums[i+1])  i++;
                    while(i < j-1 && nums[j] == nums[j-1])  j--;
                    i++;
                    j--;
                }
                else if(nums[i] + nums[j] > target) j--;
                else    i++;
            }
        }
        else {
            for(int i = start; i < nums.length; i++) {
                if(i != start && nums[i] == nums[i-1])  continue;
                list.add(nums[i]);
                kSum(nums, target-nums[i], k-1, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    public void dfs(int[] nums, int target, int k, int start, List<Integer> list) {
        if(k == 0 && target == 0) {
            re.add(new ArrayList<>(list));
            return;
        }
        
        
        else {
            for(int i = start; i < nums.length; i++) {
                if(used[i] == 1 || i != 0 && nums[i] == nums[i-1] && used[i-1] == 0)  continue;
                used[i] = 1;
                list.add(nums[i]);
                dfs(nums, target-nums[i], k-1, i+1, list);
                list.remove(list.size()-1);
                used[i] = 0;
            }
        }
    }
}