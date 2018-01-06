class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<Cdn> q = new PriorityQueue<>(new Comparator<Cdn>() {
            public int compare(Cdn c1, Cdn c2) {
                return c1.d - c2.d;
            }
        });
        Cdn st = new Cdn(start[0], start[1], 0);
        int[][] minD = new int[m][n];
        for(int i = 0; i < m; i++)  Arrays.fill(minD[i], Integer.MAX_VALUE);
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        q.offer(st); 
        while(!q.isEmpty()) {
            Cdn cur = q.poll();
            if(minD[cur.r][cur.c] <= cur.d)  continue;
            // skip if smaller distance found already
            minD[cur.r][cur.c] = cur.d;
            // Dijkstra's
            
            for(int[] act: dir) {                
                int row = cur.r, col = cur.c, d = cur.d;
                
                while(row >= 0 && col >= 0 && row < m && col < n && maze[row][col] == 0) {
                    row += act[0];
                    col += act[1];
                    d++;
                }
                row -= act[0];
                col -= act[1];
                d--;
                                
                Cdn next = new Cdn(row, col, d);
                q.offer(next);
            }
        }
        
        return minD[destination[0]][destination[1]] == Integer.MAX_VALUE? -1: minD[destination[0]][destination[1]];
    }
    
    class Cdn {
        int r, c, d;
        public Cdn(int row, int col, int dis) {
            r = row;
            c = col;
            d = dis;
        }
    }
}