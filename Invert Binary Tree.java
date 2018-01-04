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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)    return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            // swap left and right
            TreeNode l = node.left;
            node.left = node.right;
            node.right = l;
            
            if(node.left != null)   q.offer(node.left);
            if(node.right != null)  q.offer(node.right);
        }
        return root;
    }
}