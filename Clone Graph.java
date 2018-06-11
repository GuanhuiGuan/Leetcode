/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)    return node;
        return dfs(node);
    }
    
    public UndirectedGraphNode dfs(UndirectedGraphNode node) {
        if(map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        // save to map before recursion to avoid inf. loop
        // neighbors will be automatically added to the node saved
        map.put(newNode.label, newNode);
        
        List<UndirectedGraphNode> nbrs = node.neighbors;
        for(UndirectedGraphNode nbr: nbrs) {
            newNode.neighbors.add(dfs(nbr));
        }
        return newNode;
    }
}