class Solution {
    public boolean validTree(int n, int[][] edges) {
        // special union find used for check if it's DAG
        // Edge number == n-1 means it's one tree
        
        // Init with -1
        int[] roots = new int[n];
        Arrays.fill(roots, -1);
        
        // Find if cycles exist
        for(int[] edge: edges) {
            int r0 = find(roots, edge[0]);
            int r1 = find(roots, edge[1]);
            
            // If same root, cycle(s) exist
            if(r0 == r1)    return false;
            
            // Union by the roots
            roots[r1] = r0;
        }
        
        // Check if only one tree
        return edges.length == n-1;
    }
    
    // Set root of c and its predecessors to the root of p
    public int find(int[] roots, int i) {
        // When find the root
        if(roots[i] == -1)  return i;
        return find(roots, roots[i]);
    }
}