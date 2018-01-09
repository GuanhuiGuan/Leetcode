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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return root;
        if(root == p || root == q)  return root;
        TreeNode ln = lowestCommonAncestor(root.left, p, q), rn = lowestCommonAncestor(root.right, p, q);
        if(ln == null)  return rn;
        if(rn == null)  return ln;
        if(ln != null && rn != null)    return root;
        return null;
    }
}