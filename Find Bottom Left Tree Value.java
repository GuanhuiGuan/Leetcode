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
    public int findBottomLeftValue(TreeNode root) {
        // right to left BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            root = q.poll();
            if(root.right != null)  q.offer(root.right);
            if(root.left != null)   q.offer(root.left);
        }
        // the last element in queue
        return root.val;
    }
}