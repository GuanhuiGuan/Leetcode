/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // BFS(2 queues for column and node), use map to store different column buckets
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;
        
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Integer> columns = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        columns.offer(0);
        nodes.offer(root);
        
        while(!columns.isEmpty()) {
            int c = columns.poll();
            TreeNode node = nodes.poll();
            
            if(!map.containsKey(c)) map.put(c, new ArrayList<>());
            map.get(c).add(node.val);
            
            if(node.left != null) {
                columns.offer(c-1);
                nodes.offer(node.left);
            }
            
            if(node.right != null) {
                columns.offer(c+1);
                nodes.offer(node.right);
            }
        }
        
        // keyset should be inOrder
        for(int c: map.keySet()) {
            res.add(map.get(c));
        }
        return res;
    }
}