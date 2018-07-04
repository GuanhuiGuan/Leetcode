class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        // return bruteForce(N, mines);
        return oneMatrix(N, mines);
    }
    
    private int oneMatrix(int N, int[][] mines) {
        int res = 0;
        if(N == 0)  return res;
        int[][] grid = new int[N][N];
        for(int[] row: grid)    Arrays.fill(row, N);
        for(int[] mine: mines)  grid[mine[0]][mine[1]] = 0;
        
        for(int i = 0; i < N; i++) {
            // left, right, top, bottom, accumulated from 4 edges
            int l = 0, r = 0, t = 0, b = 0;
            for(int j = 0, k = N-1; j < N; j++, k--) {
                // From left
                l = grid[i][j] == 0? 0: l + 1;
                grid[i][j] = Math.min(grid[i][j], l);
                // From right
                r = grid[i][k] == 0? 0: r + 1;
                grid[i][k] = Math.min(grid[i][k], r);
                // From top
                t = grid[j][i] == 0? 0: t + 1;
                grid[j][i] = Math.min(grid[j][i], t);
                // From bottom
                b = grid[k][i] == 0? 0: b + 1;
                grid[k][i] = Math.min(grid[k][i], b);
            }
        }
        
        // Find res
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }
    
    private int bruteForce(int N, int[][] mines) {
        int res = 0;
        if(N == 0) return res;
        int[][] grid = new int[N][N];
        for(int[] row: grid)    Arrays.fill(row, 1);
        for(int[] mine: mines)  grid[mine[0]][mine[1]] = 0;
        
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int[] dirs = search(N, grid, i, j);
                res = Math.max(res, findMin(dirs));
            }
        }
        return res;
    }
    
    private int[] search(int N, int[][] grid, int i, int j) {
        int[] res = new int[4];
        for(int k = i; k >= 0; k--) {
            if(grid[k][j] == 0)    break;
            res[0]++;
        }
        
        for(int k = i; k < N; k++) {
            if(grid[k][j] == 0)    break;
            res[1]++;
        }
        
        for(int k = j; k >= 0; k--) {
            if(grid[i][k] == 0)    break;
            res[2]++;
        }
        
        for(int k = j; k < N; k++) {
            if(grid[i][k] == 0)    break;
            res[3]++;
        }
        
        return res;
    }
    
    private int findMin(int[] dirs) {
        int res = Integer.MAX_VALUE;
        for(int dir: dirs)  res = Math.min(res, dir);
        return res;
    }
}