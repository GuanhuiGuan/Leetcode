class Solution {
    List<List<Integer>> re = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        bt(candidates, target, new ArrayList<>(), 0);
        return re;
    }
    
    // can choose one multiple times
    public void bt(int[] cdd, int target, List<Integer> list, int start) {
        if(target < 0)  return;
        if(target == 0) re.add(new ArrayList<>(list));
        else {
            // set start, but next start does not increment to allow multi-pick
            for(int i = start; i < cdd.length; i++) {
                list.add(cdd[i]);
                bt(cdd, target-cdd[i], list, i);
                list.remove(list.size()-1);
            }
        }
    }
}