class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        // 2-end DFS
        List<int[]> re = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return re;
        int m = matrix.length, n = matrix[0].length;
        int[][] pv = new int[m][n], av = new int[m][n];
        
        // start from all borders
        // vertical
        for(int i = 0; i < m; i++) {
            if(pv[i][0] == 0)   dfs(pv, matrix, new int[] {i, 0});
            if(av[i][n-1] == 0)   dfs(av, matrix, new int[] {i, n-1});
        }
        // horizontal
        for(int i = 0; i < n; i++) {
            if(pv[0][i] == 0)   dfs(pv, matrix, new int[] {0, i});
            if(av[m-1][i] == 0)   dfs(av, matrix, new int[] {m-1, i});
        }
        // retrieve overlapping areas
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(av[i][j] == 1 && pv[i][j] == 1) {
                    re.add(new int[] {i, j});
                }
            }
        }
        return re;
    }
    
    public void dfs(int[][] v, int[][] matrix, int[] cur) {
        int r = cur[0], c = cur[1], m = v.length, n = v[0].length;
        v[r][c] = 1;
        for(int[] dir: dirs) {
            int nr = r+dir[0], nc = c+dir[1];
            if(nr < 0 || nc < 0 || nr >= m || nc >= n || v[nr][nc] == 1)  continue;
            // find those places water from the other ocean can flow through
            if(matrix[nr][nc] < matrix[r][c])   continue;
            dfs(v, matrix, new int[] {nr, nc});
        }
    }
    
    // _______________________________________________________________
    
    public List<int[]> pacificAtlantic_BFS(int[][] matrix) {
        // 2-end BFS
        List<int[]> re = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return re;
        int m = matrix.length, n = matrix[0].length;
        int[][] pv = new int[m][n], av = new int[m][n];
        Queue<int[]> pcf = new LinkedList<>(), alt = new LinkedList<>();
        // Initialization, add all borders
        for(int i = 0; i < m; i++) {
            pcf.add(new int[] {i, 0});
            alt.add(new int[] {i, n-1});
            pv[i][0] = 1;
            av[i][n-1] = 1;
        }
        for(int i = 0; i < n; i++) {
            pcf.add(new int[] {0, i});
            alt.add(new int[] {m-1, i});
            pv[0][i] = 1;
            av[m-1][i] = 1;
        }
        // BFS
        bfs(pcf, pv, matrix);
        bfs(alt, av, matrix);
        // retrieve overlapping areas
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(av[i][j] == 1 && pv[i][j] == 1) {
                    re.add(new int[] {i, j});
                }
            }
        }
        return re;
    }
    
    public void bfs(Queue<int[]> q, int[][] v, int[][] matrix) {
        int m = v.length, n = v[0].length;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] dir: dirs) {
                int r = cur[0]+dir[0], c = cur[1]+dir[1];
                if(r < 0 || c < 0 || r >= m || c >= n)  continue;
                if(v[r][c] == 1)    continue;
                // find those places water from the other ocean can flow through
                // if cur heigher, water from the other ocean cannot flow through
                if(matrix[cur[0]][cur[1]] > matrix[r][c])   continue;
                v[r][c] = 1;
                q.offer(new int[] {r, c});
            }
        }
    }
}