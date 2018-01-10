class Solution {
    int sum = 0;
    
    public int pathSum(int[] nums) {
        // record tree with hashmap, key=lvl+order, value=val
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n/10, n%10);
        }
        
        traverse(map, 1, 1, 0);
        return sum;
    }
    
    public void traverse(Map<Integer, Integer> map, int lvl, int order, int prev) {
        int key = lvl*10 + order;
        if(!map.containsKey(key)) {
            return;
        }
        prev += map.get(key);
        int lkey = (lvl+1)*10 + 2*order-1, rkey = (lvl+1)*10 + 2*order;
        if(!map.containsKey(lkey) && !map.containsKey(rkey)) {
            sum += prev;
            return;
        }
        traverse(map, lvl+1, 2*order-1, prev);
        traverse(map, lvl+1, 2*order, prev);
    }
}