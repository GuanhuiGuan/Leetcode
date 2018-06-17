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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }
    
    public int dfs(TreeNode node, boolean isLeft) {
        if(node == null)    return 0;
        int res = 0;
        if(isLeaf(node) && isLeft)  return node.val;
        return dfs(node.left, true) + dfs(node.right, false);
    }
    
    public boolean isLeaf(TreeNode node) {
        if(node == null || node.left != null || node.right != null)    return false;
        return true;
    }
}