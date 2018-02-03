class Solution {
    int m, n, min = Integer.MAX_VALUE;
    int[][] sumDist, dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        sumDist = new int[m][n];
        int emptyVal = 0;
        // decrement value of empty by every time a house is searched
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // start from every house
                if(grid[i][j] == 1) {
                    bfs(grid, i, j, emptyVal);
                    emptyVal--;
                }
            }
        }
        return min == Integer.MAX_VALUE? -1: min;
    }
    
    public void bfs(int[][] grid, int i, int j, int emptyVal) {
        Queue<int[]> q = new LinkedList<>();
        int dist = 0;
        q.offer(new int[] {i, j});
        // reset min when a new house is found
        min = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) {
            int size = q.size();
            dist++;
            for(int k = 0; k < size; k++) {
                int[] pos = q.poll();
                for(int[] dir: dirs) {
                    int r = dir[0] + pos[0]
                        , c = dir[1] + pos[1];
                    if(r < 0 || c < 0 || r >= m || c >= n)  continue;
                    if(grid[r][c] == emptyVal) {
                        // decrement to mark visited by house
                        grid[r][c]--;
                        sumDist[r][c] += dist;
                        q.offer(new int[] {r, c});
                        // update global min for cur-found houses
                        min = Math.min(min, sumDist[r][c]);
                    }
                }
            }
        }
    }
}