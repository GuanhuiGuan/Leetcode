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
    public int maxDepth(TreeNode root) {
        return search(root, 0);
    }
    
    public int search(TreeNode node, int depth){
        if(node == null)    return depth;
        depth++;
        int leftDepth = depth;
        int rightDepth = depth;
        if(node.left != null)   leftDepth = search(node.left, depth);
        if(node.right != null)   rightDepth = search(node.right, depth);
        return Math.max(leftDepth, rightDepth);
    }
}