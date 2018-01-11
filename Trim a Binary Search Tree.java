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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)    return null;
        TreeNode ln = trimBST(root.left, L, R);
        TreeNode rn = trimBST(root.right, L, R);
        
        // all left are out of bound
        if(root.val < L)    return rn;
        // all right are out of bound
        else if(root.val > R)   return ln;
        // root not trim; update root
        else {
            root.left = ln;
            root.right = rn;
            return root;
        }
    }
}