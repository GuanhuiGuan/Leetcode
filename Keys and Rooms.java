class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // return bfs(rooms);
        return dfs(rooms);
    }
    
    private boolean dfs(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        
        dHelp(rooms, 0, visited);
        return visited.size() == rooms.size();
    }
    
    private void dHelp(List<List<Integer>> rooms, int room, Set<Integer> visited) {
        visited.add(room);
        List<Integer> keys = rooms.get(room);
        if(keys == null)    return;
        for(int key: keys) {
            if(!visited.contains(key))  dHelp(rooms, key, visited);
        }
    }
    
    private boolean bfs(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.offer(0);
        while(!q.isEmpty()) {
            for(int k = q.size(); k > 0; k--) {
                int room = q.poll();
                visited.add(room);
                List<Integer> keys = rooms.get(room);
                if(keys != null) {
                    for(int key: keys) {
                        if(!visited.contains(key))  q.offer(key);
                    }
                }
            }
        }
        
        return visited.size() == rooms.size();
    }
}