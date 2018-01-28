class NumMatrix {
    // Binary Indexed Tree - 2D
    int m, n;
    int[][] BIT, nums;

    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        nums = new int[m][n];
        BIT = new int[m+1][n+1];
        // Init
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    // get delta, update num, update BIT
    public void update(int row, int col, int val) {
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for(int i = row+1; i <= m; i += (i & (-i))) {
            for(int j = col+1; j <= n; j += (j & (-j))) {
                BIT[i][j] += delta;
            }
        }
    }
    
    // subtract ones(smaller index) should minus 1, because end index is inclusive
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return BITsum(row2, col2) + BITsum(row1-1, col1-1) - BITsum(row1-1, col2) - BITsum(row2, col1-1);
    }
    
    // add all along the path(going upwards to 0, 0 exclusive)
    public int BITsum(int r, int c) {
        int sum = 0;
        for(int i = r+1; i > 0; i -= (i & (-i))) {
            for(int j = c+1; j > 0; j -= (j & (-j))) {
                sum += BIT[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */