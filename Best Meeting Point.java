class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        
        // record their rows and cols
        List<Integer> rows = new ArrayList<>(), cols = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        // return min dist sums for row and col
        int mRow = findMin(rows, m);
        int mCol = findMin(cols, n);
        return mRow + mCol;
    }
    
    public int findMin(List<Integer> list, int len) {
        // sort and add distances between further two groups
        int res = 0, s = 0, e = list.size()-1;
        Collections.sort(list);
        while(s < e)    res += list.get(e--) - list.get(s++);
        return res;
        
        // int res = Integer.MAX_VALUE;
        // // try positions
        // for(int p = 0; p < len; p++) {
        //     int sum = 0;
        //     for(int ind: list) sum += Math.abs(ind - p);
        //     res = Math.min(res, sum);
        // }
        // return res;
    }
}