class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> re = new ArrayList<>();
        if(n < 2)   return re;
        helper(re, new ArrayList<Integer>(), n, 2);
        return re;
    }
    
    public void helper(List<List<Integer>> re, List<Integer> list, int n, int start){
        // a list is complete: add to re
        if(n <= 1){
            if(list.size() > 1){
                re.add(new ArrayList(list));
            }
        }
        else{
            // not complete: continue recursive DFS
            for(int i = start; i <= n; i++){
                if(n%i == 0){
                    list.add(i);
                    helper(re, list, n/i, i);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}