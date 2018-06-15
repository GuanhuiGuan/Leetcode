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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }
    
    public boolean dfs(TreeNode node, TreeNode min, TreeNode max) {
        if(node == null)    return true;
        if(min != null && min.val >= node.val || max != null && max.val <= node.val)    return false;
        return dfs(node.left, min, node) && dfs(node.right, node, max);
    }
}