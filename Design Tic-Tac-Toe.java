class TicTacToe {
    int size;
    int[] rows;
    int[] cols;
    // only two ways to win diagonally
    int diag = 0;
    int antiDiag = 0;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int mov = player == 1? 1: -1;
        
        rows[row] += mov;
        cols[col] += mov;
        if(row == col)  diag += mov;
        if((size-1 - col) == row)   antiDiag += mov;
        if(Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diag) == size || Math.abs(antiDiag) == size)  return player;
        return 0;
    }
}


// // Original
// class TicTacToe {
//     int[][] board;
//     int m;
    
//     /** Initialize your data structure here. */
//     public TicTacToe(int n) {
//         board = new int[n][n];
//         m = n;
//         // 0 is empty, 1 is X, 2 is O
//     }
    
//     /** Player {player} makes a move at ({row}, {col}).
//         @param row The row of the board.
//         @param col The column of the board.
//         @param player The player, can be either 1 or 2.
//         @return The current winning condition, can be either:
//                 0: No one wins.
//                 1: Player 1 wins.
//                 2: Player 2 wins. */
//     public int move(int row, int col, int player) {
//         // invalid move
//         if(board[row][col] != 0)    return 0;
        
//         board[row][col] = player;
//         if(search(row, col, player))  return player;
//         else    return 0;
//     }
    
//     public boolean search(int row, int col, int player){
//         int hor = count(row, col, 0, -1, player) + count(row, col, 0, 1, player) + 1;
//         int ver = count(row, col, -1, 0, player) + count(row, col, 1, 0, player) + 1;
//         int lTop = count(row, col, -1, -1, player) + count(row, col, 1, 1, player) + 1;
//         int rTop = count(row, col, -1, 1, player) + count(row, col, 1, -1, player) + 1;
//         return (hor == m || ver == m || lTop == m || rTop == m);
//     }
    
//     public int count(int row, int col, int dr, int dc, int player){
//         int r = row+dr, c = col+dc;
//         if(r >=0 && r < m && c >= 0 && c < m && board[r][c] == player){
//             return 1+count(r, c, dr, dc, player);
//         }
//         else{
//             return 0;
//         }
//     }
// }


// /**
//  * Your TicTacToe object will be instantiated and called as such:
//  * TicTacToe obj = new TicTacToe(n);
//  * int param_1 = obj.move(row,col,player);
//  */