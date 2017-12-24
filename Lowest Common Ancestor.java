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
        if(root == null || root == p || root == q)    return root;
        // search both sides, return node if found else null
        TreeNode ln = lowestCommonAncestor(root.left, p, q);
        TreeNode rn = lowestCommonAncestor(root.right, p, q);
        // p, q on left and right, return root
        if(ln != null && rn != null)    return root;
        //one of them null, on one side
        if(ln != null)  return ln;
        else    return rn;
    }
}