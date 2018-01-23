class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; i++) {
            if(i != 0 && nums[i] == nums[i-1])  continue; // skip duplicate c
            int c = -nums[i];
            int lo = i+1, hi = nums.length-1;
            while(lo < hi) {
                int ab = nums[lo] + nums[hi];
                if(ab == c) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    re.add(list);
                    // skip duplicates a, b when found new result
                    while(lo+1 < hi && nums[lo+1] == nums[lo])  lo++;
                    while(lo < hi-1 && nums[hi-1] == nums[hi])  hi--;
                    lo++;
                    hi--;
                }
                else if(ab > c) hi--;
                else    lo++;
            }
        }
        return re;
    }
    
//     // k-sum, not time optimal
//     List<List<Integer>> re = new ArrayList<>();
//     int[] used;
    
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         used = new int[nums.length];
//         dfs(nums, 3, 0, 0, new ArrayList<>());
//         return re;
//     }
    
//     public void dfs(int[] nums, int k, int curSum, int start, List<Integer> list) {
//         if(curSum == 0 && k == 0) {
//             re.add(new ArrayList<>(list));
//             return;
//         }
//         if(curSum != 0 && k == 0)   return;
        
//         for(int i = start; i < nums.length; i++) {
//             if(used[i] == 1 || i != 0 && nums[i-1]==nums[i] && used[i-1] == 0)  continue;
//             used[i] = 1;
//             list.add(nums[i]);
//             dfs(nums, k-1, curSum+nums[i], i+1, list);
//             list.remove(list.size()-1);
//             used[i] = 0;
//         }
//     }
}