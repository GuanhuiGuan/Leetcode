class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // topological sort
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degrees = new int[numCourses];
        
        // Init graph and degrees
        for(int[] prereq: prerequisites) {
            // Save children
            List<Integer> children = graph.get(prereq[1]);
            if(children == null)   children = new ArrayList<>();
            children.add(prereq[0]);
            graph.put(prereq[1], children);
            
            // Add degree to the child
            degrees[prereq[0]]++;
        }
        
        // Init queue(add those without predecessor)
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(degrees[i] == 0) q.offer(i);
        }
        
        // Sort
        int[] res = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            res[index++] = cur;
            List<Integer> children = graph.get(cur);
            if(children == null)    continue;
            for(int child: children) {
                if(--degrees[child] == 0)   q.offer(child);
            }
        }
        // if cyclic, some node will never be added to queue
        return index == numCourses? res: new int[0];
    }
}