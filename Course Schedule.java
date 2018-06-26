class Solution {
    int[] colors;
    boolean res = true;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // DFS check if it's DAG
        // 0, 1, 2 --> white, gray, black
        colors = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        
        for(int[] prereq: prerequisites) {
            // add child
            graph.get(prereq[1]).add(prereq[0]);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(colors[i] == 0)    dfs(graph, i);
        }
        return res;
    }
    
    private void dfs(List<List<Integer>> graph, int i) {
        colors[i] = 1;
        List<Integer> list = graph.get(i);
        if(list != null) {
            for(int next: list) {
                if(colors[next] == 1) res = false;
                else if(colors[next] == 0)  dfs(graph, next);
            }
        }
        colors[i] = 2;
    }
}