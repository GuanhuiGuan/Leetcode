class Solution {
    class Cdn {
        int r;
        int c;
        public Cdn(int row, int col) {
            r = row;
            c = col;
        }
    }
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] visited = new int[m][n];
        Queue<Cdn> q = new LinkedList<>();
        Cdn st = new Cdn(start[0], start[1]), des = new Cdn(destination[0], destination[1]);
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        q.offer(st);
        while(!q.isEmpty()) {
            Cdn cur = q.poll();
            for(int[] act: dir) {
                int rn = cur.r, cn = cur.c;
                // keep going one direction
                while(rn >= 0 && cn >= 0 && rn < m && cn < n && maze[rn][cn] == 0){
                    rn += act[0];
                    cn += act[1];
                }
                
                // get the last valid coordinate
                rn -= act[0];
                cn -= act[1];
                if(visited[rn][cn] == 1)    continue;
                visited[rn][cn] = 1;
                if(rn == des.r && cn == des.c)  return true;
                
                Cdn next = new Cdn(rn, cn);
                q.offer(next);
            }
        }
        return false;
    }
}