class Solution {
    List<List<Integer>> re = new ArrayList<>();
    
    public List<List<Integer>> getFactors(int n) {
        helper(n, 2, new ArrayList<>());
        return re;
    }
    
    public void helper(int n, int start, List<Integer> list) {
        // start is here to avoid duplicate states
        // size avoids the original integer
        if(n <= 1 && list.size() > 1) {
            re.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n; i++) {
            if(n%i == 0) {
                list.add(i);
                helper(n/i, i, list);
                list.remove(list.size()-1);
            }
        }
    }
}