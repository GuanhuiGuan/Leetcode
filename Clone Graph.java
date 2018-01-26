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
        if(node == null)    return null;
        if(map.containsKey(node.label))   return map.get(node.label);
        
        UndirectedGraphNode cn = new UndirectedGraphNode(node.label);
        map.put(cn.label, cn);
        for(UndirectedGraphNode next: node.neighbors) {
            cn.neighbors.add(cloneGraph(next));
        }
        return cn;
    }
}