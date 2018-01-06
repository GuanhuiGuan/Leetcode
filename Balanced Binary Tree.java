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
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        return Math.abs(height(root.left) - height(root.right)) < 2 
            && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int height(TreeNode node) {
        if(node == null)    return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }
}