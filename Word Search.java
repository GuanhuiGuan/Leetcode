class Solution {
    int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(check(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean check(char[][] board, int i, int j, String word, int k) {
        if(k == word.length())  return true;
        if(i < 0 || j < 0 || i >= m || j >= n 
           || visited[i][j] || board[i][j] != word.charAt(k))   return false;
        visited[i][j] = true;
        
        for(int[] dir: dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if(check(board, ni, nj, word, k+1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}