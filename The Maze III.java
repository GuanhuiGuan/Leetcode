class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        Cdn[][] cdns = new Cdn[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                cdns[i][j] = new Cdn(i, j, Integer.MAX_VALUE, "");
            }
        }  
        
        Queue<Cdn> q = new PriorityQueue<Cdn>(new Comparator<Cdn>(){
            public int compare(Cdn o1, Cdn o2) {
                if(o1.d == o2.d)    return o1.p.compareTo(o2.p);
                return o1.d - o2.d;
            }
        });
        Queue<String> re = new PriorityQueue<>();
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String[] name = {"u", "d", "l", "r"};
        
        Cdn st = new Cdn(ball[0], ball[1], 0, "");
        q.offer(st);
        while(!q.isEmpty()) {
            Cdn cur = q.poll();
            if(cdns[cur.r][cur.c].cmp(cur) <= 0) continue;
            cdns[cur.r][cur.c] = cur;
            
            for(int i = 0; i < 4; i++) {
                int row = cur.r, col = cur.c, d = cur.d;
                String p = cur.p;
                // if hole reached, the ball is also stopped
                while(row >= 0 && col >= 0 && row < m && col < n && maze[row][col] == 0 && (row != hole[0] || col != hole[1])) {
                    row += dir[i][0];
                    col += dir[i][1];
                    d++;
                }
                if(row != hole[0] || col != hole[1]) {
                    row -= dir[i][0];
                    col -= dir[i][1];
                    d--;
                }
                
                q.offer(new Cdn(row, col, d, p+name[i]));
            }
        }
        
        return cdns[hole[0]][hole[1]].d == Integer.MAX_VALUE? "impossible": cdns[hole[0]][hole[1]].p;
    }
    
    class Cdn {
        int r, c, d;
        String p;
        public Cdn(int _r, int _c, int _d, String _p) {
            r = _r;
            c = _c;
            d = _d;
            p = _p;
        }
        
        public int cmp(Cdn next) {
            if(d == next.d) return p.compareTo(next.p);
            return d-next.d;
        }
    }
}