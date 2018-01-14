class Solution {
    // hashmap record tried states, state record used integers
    Map<String, Boolean> map = new HashMap<>();
    int[] state;
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int mci = maxChoosableInteger, dt = desiredTotal;
        state = new int[mci];
        int max = (mci+1)*mci/2;
        if(max < dt)    return false;
        
        return helper(dt);
    }
    
    public boolean helper(int dt) {
        String s = Arrays.toString(state);
        if(map.containsKey(s))  return map.get(s);
        for(int i = 0; i < state.length; i++) {
            if(state[i] == 0) {
                state[i] = 1;
                // if >= target or opponent lost
                if(i+1 >= dt || !helper(dt-i-1)) {
                    map.put(s, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }
        map.put(s, false);
        return false;
    }
}