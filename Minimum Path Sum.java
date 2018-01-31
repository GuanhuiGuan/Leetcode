class Solution {
    // go right or down
    int[][] dirs = {{1, 0}, {0, 1}};
    int m, n;
    
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int r = 0, c = 0;
        int[][] sum = new int[m][n];
        
        // dp, sweep backwards
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                sum[i][j] = grid[i][j];
                int down = i==m-1? Integer.MAX_VALUE: sum[i+1][j];
                int right = j==n-1? Integer.MAX_VALUE: sum[i][j+1];
                if(down == Integer.MAX_VALUE && right == Integer.MAX_VALUE) continue;
                sum[i][j] += Math.min(down, right);
            }
        }
        return sum[0][0];
    }
}