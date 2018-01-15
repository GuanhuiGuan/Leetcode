class Solution {
    
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)  return matrix;
        int n = matrix[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer[]> queue = new LinkedList<>();

        // 1. Initialize dist and queue
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] != 0)   matrix[i][j] = Integer.MAX_VALUE;
                else    queue.offer(new Integer[] {i, j});
            }
        }
        
        // 2. BFS
        while(!queue.isEmpty()) {
            Integer[] cur = queue.poll();
            for(int[] act: dir) {
                int nr = cur[0]+act[0], nc = cur[1]+act[1];
                if(nr < 0 || nr >= m || nc < 0 || nc >= n)  continue;
                if(matrix[nr][nc] < 1+matrix[cur[0]][cur[1]])   continue;
                matrix[nr][nc] = 1+matrix[cur[0]][cur[1]];
                queue.offer(new Integer[] {nr, nc});
            }
        }
        return matrix;
    }
}