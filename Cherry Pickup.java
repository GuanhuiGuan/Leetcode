class Solution {
    public int cherryPickup(int[][] grid) {
        // DP: simulate that walk distance k forward and backward
        // the total walk horizontal + vertical = (N-1) + (N-1) = 2*N-2
        int N = grid.length, maxDist = 2*N-2;
        // DP[i][j], i -> x-coordinate of 1st walk, j -> x-coordinate of 2nd walk
        // their y-coordinates are k-i, k-j
        int[][] DP = new int[N][N];
        for(int[] line: DP) Arrays.fill(line, -1);
        DP[0][0] = grid[0][0];
        
        // increment distance
        for(int dist = 1; dist <= maxDist; dist++) {
            // new cache DP grid
            int[][] next = new int[N][N];
            for(int[] line: next) Arrays.fill(line, -1);
            
            // can walk up to N-1 or k
            for(int i = 0; i <= Math.min(N-1, dist); i++) {
                for(int j = 0; j <= Math.min(N-1, dist); j++) {
                    // check if y-coordinates out of bound
                    if(dist - i >= N || dist - j >= N)  continue;
                    // check if can walk through
                    if(grid[i][dist-i] == -1 || grid[j][dist-j] == -1)  continue;
                    
                    // cherry at with such route
                    int curCherry = DP[i][j];
                    // search nearby positions
                    if(i > 0)   curCherry = Math.max(curCherry, DP[i-1][j]);
                    if(j > 0)   curCherry = Math.max(curCherry, DP[i][j-1]);
                    if(i > 0 && j > 0)  curCherry = Math.max(curCherry, DP[i-1][j-1]);
                    // if still -1, can't be reached
                    if(curCherry < 0)   continue;
                    
                    // save count in the new cache DP map
                    // through the same spot or different
                    if(i == j)  next[i][j] = curCherry + grid[i][dist-i];
                    else    next[i][j] = curCherry + grid[i][dist-i] + grid[j][dist-j];
                }
            }
            DP = next;
        }
        return Math.max(DP[N-1][N-1], 0);
    }
}