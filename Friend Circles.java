class Solution {
    // DFS
    int[] visited;
    public int findCircleNum(int[][] M) {
        int n = M.length, count = 0;
        visited = new int[n];
        
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                count++;
                dfs(M, i);
            }
        }
        return count;
    }
    
    public void dfs(int[][] M, int i) {
        visited[i] = 1;
        // DFS starts from 0, search all
        for(int j = 0; j < M.length; j++) {
            if(M[i][j] == 1 && visited[j] == 0) {
                dfs(M, j);
            }
        }
    }
    
    
    // union find
    int[] parent;
    
    public int findCircleNum(int[][] M) {
        int n = M.length, cycles = n;
        parent = IntStream.range(0, n).toArray();
        
        for(int i = 0; i < n; i++) {
            int pi = find(i);
            for(int j = i+1; j < n; j++) {
                if(M[i][j] == 0)    continue;
                int pj = find(j);
                if(pj != pi) {
                    parent[pj] = pi;
                    cycles--;
                }
            }
        }
        
        return cycles;
    }
    
    public int find(int x) {
        if(parent[x] == x)  return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}