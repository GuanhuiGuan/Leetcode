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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSame(s, t) ||
            (s.left != null && isSubtree(s.left, t)) ||
            (s.right != null && isSubtree(s.right, t));
    }
    
    public boolean isSame(TreeNode x, TreeNode y) {
        if(x == null && y == null)  return true;
        if(x == null || y == null)  return false;
        return x.val == y.val && isSame(x.left, y.left) && isSame(x.right, y.right);
    }
}