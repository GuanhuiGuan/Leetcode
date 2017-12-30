class Solution {
    int m, n;
    int maxL = 0;
    int[][] cache;
    int[][] act = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if(m == 0)  return 0;
        n = matrix[0].length;
        cache = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                maxL = Math.max(maxL, dfs(matrix, i, j));
            }
        }
        return maxL;
    }
    
    public int dfs(int[][] matrix, int i, int j){
        if(cache[i][j] != 0)  return cache[i][j];
        cache[i][j] = 1;
        int maxV = 1;
        for(int[] pair: act){
            int row = i+pair[0], col = j+pair[1];
            if(row < 0 || col < 0 || row >= m || col >= n || matrix[row][col] <= matrix[i][j])  continue;
            maxV = Math.max(maxV, 1+dfs(matrix, row, col));
        }
        
        cache[i][j] = maxV;
        return cache[i][j];
    }
}