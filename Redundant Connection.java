class Solution {
    int[] parent;
    
    public int[] findRedundantConnection(int[][] edges) {
        // union find, use node as the mark of the union
        // find parents of two nodes, if same parent, return edge, else, merge two parents
        parent = new int[2001]; // at most 2000 points
        // initialize parent, each node is its own parent
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for(int[] e: edges) {
            // find parents of both nodes
            int p1 = find(e[0]), p2 = find(e[1]);
            if(p1 == p2)    return e;
            // merge by setting p2's parent as p1
            else    parent[p2] = p1;
        }
        
        return new int[2];
    }
    
    // find the source parent of x
    public int find(int x) {
        int p = parent[x];
        if(p != x)  parent[x] = find(p);
        return parent[x];
    }
}