class Solution {
    public int countCornerRectangles(int[][] grid) {
        // Pick two rows, sweep to find number of 2 vertical-aligned 1s
        // res += combination of these found vertical 1s
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m-1; i++) {
            for(int j = i+1; j < m; j++) {
                int count = 0;
                for(int k = 0; k < n; k++) {
                    // Record count of vertical-aligned ones
                    if(grid[i][k] == 1 && grid[j][k] == 1)  count++;
                }
                // Any two of these ones could form a cornered rectangle
                if(count > 0)   res += (count-1 + 1) * (count-1)/2;
            }
        }
        return res;
    }
}