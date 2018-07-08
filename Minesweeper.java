class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> q = new LinkedList<>();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        // If click on M, game over
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        // Game continues
        q.offer(click);
        while(!q.isEmpty()) {
            Set<int[]> temp = new HashSet<>();
            
            int[] pos = q.poll();
            visited[pos[0]][pos[1]] = true;
            
            // If E, check adjacent
            if(board[pos[0]][pos[1]] == 'E') {
                int count = 0;
                for(int[] dir: dirs) {
                    int row = pos[0] + dir[0], col = pos[1] + dir[1];
                    if(row < 0 || col < 0 || row >= m || col >= n || visited[row][col] || board[row][col] == 'B') continue;
                    if(board[row][col] == 'M')  count++;
                    else if(board[row][col] == 'E') temp.add(new int[] {row, col});
                }
                
                // Only add to queue if current pos is B
                if(count == 0) {
                    board[pos[0]][pos[1]] = 'B';
                    q.addAll(temp);
                }
                else    board[pos[0]][pos[1]] = (char)('0' + count);
            }
        }
        
        return board;
    }
}