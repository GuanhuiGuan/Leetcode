class Solution {
    int m;
    int n;
    
    public void solve(char[][] board) {
        m = board.length;
        if(m == 0)   return;
        n = board[0].length;
        
        
        // check border O and mark them F
        for(int i = 0; i < m; i++){
            search(board, i, 0, 'F');
            search(board, i, n-1, 'F');
        }
        for(int j = 0; j < n; j++){
            search(board, 0, j, 'F');
            search(board, m-1, j, 'F');
        }
        
        // change those remaining O to X
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
        // change F to O
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'F'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    // find O and change it to c
    public void search(char[][] board, int i, int j, char c){
        if(i < 0 || j < 0 || i >= m || j >= n)  return;
        
        // change O
        if(board[i][j] == 'O'){
            board[i][j] = c;
            // find neighbors(dfs)
            search(board, i-1, j, c);
            search(board, i+1, j, c);
            search(board, i, j-1, c);
            search(board, i, j+1, c);
        }
    }
}