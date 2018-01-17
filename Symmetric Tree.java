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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)    return true;
        return checkTwo(root.left, root.right);
    }
    
    public boolean checkTwo(TreeNode ln, TreeNode rn) {
        if(ln == null || rn == null)    return ln==rn;
        if(ln.val != rn.val)    return false;
        return checkTwo(ln.left, rn.right) && checkTwo(ln.right, rn.left);
    }
}