class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 1 || edges == null)   return new ArrayList<>();
        else if(n < 2)  return new ArrayList<>(Arrays.asList(0));
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge: edges) {
            int n0 = edge[0], n1 = edge[1];
            graph.putIfAbsent(n0, new HashSet<>());
            graph.get(n0).add(n1);
            graph.putIfAbsent(n1, new HashSet<>());
            graph.get(n1).add(n0);
        }
        
        // Starting from every leaves(degree==1), move till n <= 2(tree V=n, E=n-1)
        List<Integer> leaves = new ArrayList<>();
        
        // Init leaves
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() == 1)    leaves.add(i);
        }
        
        // Similar to topological sort
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf: leaves) {
                int next = graph.get(leaf).iterator().next();
                // Remove the current leaf
                graph.get(next).remove(leaf);
                if(graph.get(next).size() == 1) newLeaves.add(next);
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}