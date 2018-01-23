class Solution {
    int[][] used;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0)  return 0;
        int n = grid[0].length;
        used = new int[m][n];
        
        int islands = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && used[i][j] == 0) {
                    islands++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return islands;
    }
    
    public void dfs(char[][] grid, int i, int j, int m, int n) {
        if(i < 0 || j < 0 || i >= m || j >= n)  return;
        if(grid[i][j] == '0' || used[i][j] == 1)    return;
        used[i][j] = 1;
        for(int[] dir: dirs) {
            int ni = i+dir[0], nj = j+dir[1];
            dfs(grid, ni, nj, m, n);
        }
    }
}