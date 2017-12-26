class Solution {
    boolean[] visited;
    Map<String, Boolean> map;
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= 0)   return true;
        if(maxChoosableInteger*(maxChoosableInteger+1)/2 < desiredTotal)  return false;
        
        visited = new boolean[maxChoosableInteger+1];
        Arrays.fill(visited, false);
        map = new HashMap<>();
        return dp(desiredTotal);
    }
    
    public boolean dp(int desiredTotal){
        if(desiredTotal <= 0)   return false;
        String key = Arrays.toString(visited);
        
        if(!map.containsKey(key)){
            // find out what next player can do
            for(int i = 1; i < visited.length; i++){
                if(visited[i] == false){
                    visited[i] = true;
                    // when the other player lost, cur player won
                    if(!dp(desiredTotal - i)){
                        visited[i] = false;
                        map.put(key, true);
                        return true;
                    }
                    // cur player lost; reset visited and try new ones
                    visited[i] = false;
                }
            }
            // every option fails(other player won); lost
            map.put(key, false);
        }
        
        return map.get(key);
    }
}