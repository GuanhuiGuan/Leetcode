class Solution {
    List<List<Integer>> re = new ArrayList<>();
    int[] used;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new int[candidates.length];
        bt(candidates, target, 0, new ArrayList<>());
        return re;
    }
    
    public void bt(int[] cdd, int target, int start, List<Integer> list) {
        if(target == 0) re.add(new ArrayList<>(list));
        else if(target < 0) return; // optimize
        else {
            for(int i = start; i < cdd.length; i++) {
                if(used[i]== 1 || i != 0 && cdd[i]==cdd[i-1] && used[i-1] == 0)   continue;
                used[i] = 1;
                list.add(cdd[i]);
                bt(cdd, target-cdd[i], i+1, list);
                list.remove(list.size()-1);
                used[i] = 0;
            }
        }
    }
}