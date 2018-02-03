class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0)  return;
        int m = rooms.length, n = rooms[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0)    q.offer(new int[] {i, j});
            }
        }
        while(!q.isEmpty()) {
            // lvl by lvl traversal
            int size = q.size();
            for(int k = 0; k < size; k++) {
                int[] pos = q.poll();
                int dist = rooms[pos[0]][pos[1]];
                for(int[] act: dirs) {
                    int r = act[0] + pos[0], c = act[1] + pos[1];
                    if(r < 0 || c < 0 || r >= m || c >= n)  continue;
                    // update and search if distance is greater
                    if(rooms[r][c] > dist + 1) {
                        rooms[r][c] = dist + 1;
                        q.offer(new int[] {r, c});
                    }
                }
            }
        }
    }
}