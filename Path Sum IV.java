// Iterative method
class Solution {
    public int pathSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // initialize tree in a map
        for(int num: nums) {
            int key = num/10, val = num%10;
            map.put(key, val);
        }
        
        // iterate again, update value from top to bottom in map(lvl to lvl walk)
        int sum = 0;
        for(int num: nums) {
            int key = num/10, val = num%10;
            int lvl = key/10, pos = key%10;
            // get key to potential children
            int lc = (lvl+1)*10 + 2*pos-1, rc = (lvl+1)*10 + 2*pos;
            // if any child exist, add value
            if(map.containsKey(lc)) map.put(lc, map.get(lc)+map.get(key));
            if(map.containsKey(rc)) map.put(rc, map.get(rc)+map.get(key));
            // no children, collect leaves
            if(!map.containsKey(lc) && !map.containsKey(rc))    sum += map.get(key);
        }
        return sum;
    }
}

// Recursion method
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