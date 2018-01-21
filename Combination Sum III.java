class Solution {
    List<List<Integer>> re = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1, new ArrayList<>());
        return re;
    }
    
    public void dfs(int k, int n, int start, List<Integer> list) {
        if(n == 0 && list.size() == k) {
            re.add(new ArrayList<>(list));
            return;
        }
        if(n < 0 || list.size() > k)    return;
        
        for(int i = start; i < 10; i++) {
            if(!list.contains(i)) {
                list.add(i);
                dfs(k, n-i, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}