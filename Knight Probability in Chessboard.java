class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double total = Math.pow(8, K);
        double[][] board = new double[N][N];
        for(double[] col: board)   Arrays.fill(col, 1); // state at last at this pos is 1
        int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {2, -1}, {2, 1}, {1, -2}, {1, 2}};
        
        // count how many ways to stay on the board; counting backwards
        for(int k = 0; k < K; k++) {
            // each step, get a new board, collect amount of ways to get here
            double[][] b = new double[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    for(int[] act: dir) {
                        // nr, nc are from 1 step before getting to i, j
                        int nr = i+act[0], nc = j+act[1];
                        if(nr < 0 || nc < 0 || nr >= N || nc >= N)  continue;
                        // if not out of bound, there're such many extra ways to get to i, j
                        b[i][j] += board[nr][nc];
                    }
                }
            }
            board = b;  // update board
        }
        
        return board[r][c]/total;
    }
}

// DFS Solution: not optimal, for standard graph like chessboard, better use loops of loops
// class Solution {
//     double sum = 0;
//     int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {2, -1}, {2, 1}, {1, -2}, {1, 2}};
//     Map<int[], Double> map = new HashMap<>();
    
//     public double knightProbability(int N, int K, int r, int c) {
//         // DFS with memorization
//         return dfs(r, c, K, N);
        
//         // double total = Math.pow(8, K);
//         // dfs(r, c, K, N);
//         // return sum/total;
//     }
    
//     public double dfs(int r, int c, int K, int N) {
//         int[] cdn = new int[] {r, c};
//         if(map.containsKey(cdn))    return map.get(cdn);
//         if(r < 0 || c < 0 || r >= N || c >= N) {
//             map.put(cdn, (double) 0.0);
//             return (double) 0.0;
//         }
//         if(K == 0) {
//             map.put(cdn, (double) 1.0);
//             return (double) 1.0;
//         }
        
//         double prob = 0;
//         for(int[] act: dir) {
//             prob += dfs(r+act[0], c+act[1], K-1, N);
//         }
//         return 0.125*prob;
//     }
// }