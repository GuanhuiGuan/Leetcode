class Solution {
    char[][] pairs = new char[][] {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
    public int strobogrammaticInRange(String low, String high) {
        // DFS count from both ends, store char array, remove limits
        // compareTo() should be supported by length
        if(low == null || high == null 
           || low.length() > high.length()
           || low.length() == high.length() && low.compareTo(high) > 0)  return 0;
        int re = 0;
        for(int i = low.length(); i <= high.length(); i++) {
            re += dfs(new char[i], 0, i-1, low, high);
        }
        return re;
    }
    
    public int dfs(char[] cs, int left, int right, String low, String high) {
        // termination
        if(left > right) {
            String cur = new String(cs);
            // check if out of bound
            if(cur.length() == low.length() && cur.compareTo(low) < 0
               || cur.length() == high.length() && cur.compareTo(high) > 0) return 0;
            else    return 1;
        }
        
        int sum = 0;
        for(char[] pair: pairs) {
            cs[left] = pair[0];
            cs[right] = pair[1];
            // start with 0
            if(cs.length > 1 && cs[0] == '0')   continue;
            // 6/9 in mid
            if(left == right && (pair[0] == '6' || pair[0] == '9')) continue;
            sum += dfs(cs, left+1, right-1, low, high);
        }
        return sum;
    }
}