class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++)  parent[i] = i;
        
        for(int[] e: edges) {
            int p0 = find(parent, e[0]);
            int p1 = find(parent, e[1]);
            if(p0 == p1)    return false;
            parent[p1] = p0;
        }
        return edges.length == n-1;
    }
    
    public int find(int[] parent, int i) {
        int p = parent[i];
        if(p == i)  return p;
        parent[i] = find(parent, p);
        return parent[i];
    }
}