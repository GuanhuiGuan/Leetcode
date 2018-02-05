class Solution {
    int m, n;
    
    public int[][] candyCrush(int[][] board) {
        m = board.length;
        n = board[0].length;
        
        Set<int[]> reset = check(board);
        if(reset.isEmpty()) return board; 
        board = collapse(board, reset);
        return candyCrush(board);
    }
    
    public Set<int[]> check(int[][] board) {
        //search crush positions
        Set<int[]> reset = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // skip all 0s!!
                if(board[i][j] == 0)    continue;
                // check 4 directions, 2 steps on one side or 1 step on both sides
                if(i > 1 && board[i-1][j] == board[i][j] && board[i-2][j] == board[i][j] ||
                   i < m-2 && board[i+1][j] == board[i][j] && board[i+2][j] == board[i][j] || 
                   i > 0 && board[i-1][j] == board[i][j] && i < m-1 && board[i+1][j] == board[i][j] ||
                   j > 1 && board[i][j-1] == board[i][j] && board[i][j-2] == board[i][j] ||
                   j < n-2 && board[i][j+1] == board[i][j] && board[i][j+2] == board[i][j] || 
                   j > 0 && board[i][j-1] == board[i][j] && j < n-1 && board[i][j+1] == board[i][j]) {
                    
                    reset.add(new int[] {i, j});
                }
            }
        }
        return reset;
    }
    
    public int[][] collapse(int[][] board, Set<int[]> reset) {
        // set value to 0
        for(int[] pos: reset)   board[pos[0]][pos[1]] = 0;
        
        // collapse empty spaces, 2ptrs, col by col
        for(int j = 0; j < n; j++) {
            int top = m-1, bot = m-1;
            while(top >= 0) {
                if(board[top][j] == 0)  top--;
                else {
                    board[bot][j] = board[top][j];
                    bot--;
                    top--;
                }
            }
            while(bot >= 0) {
                board[bot][j] = 0;
                bot--;
            }
        }
        return board;
    }
}