class Solution {
    int[] set;
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        set = new int[n];
        
        // DFS to put node in set -1 or 1, and put all adjacent ones in the opposite set
        // If set conflict, false
        // Loop to only start at those not tried yet
        for(int i = 0; i < n; i++) {
            if(set[i] == 0 && !dfs(graph, i, 1))    return false;
        }
        return true;
    }
    
    public boolean dfs(int[][] graph, int i, int toSet) {
        // return now to avoid inf loop
        if(set[i] != 0) return set[i] == toSet;
        
        set[i] = toSet;
        for(int next: graph[i]) {
            if(!dfs(graph, next, 0-toSet))  return false;
        }
        return true;
    }
}