class Solution {
    List<List<Integer>> re = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        bt(n, k, new ArrayList<>(), 1);
        return re;
    }
    
    public void bt(int n, int k, List<Integer> list, int start) {
        if(list.size() == k)    re.add(new ArrayList<>(list));
        else {
            for(int i = start; i <= n; i++) {
                if(list.contains(i))    continue;
                list.add(i);
                bt(n, k, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}