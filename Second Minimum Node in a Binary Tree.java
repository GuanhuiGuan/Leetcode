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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)    return -1;
        
        // only return value that's not equal to root value
        int ls = -1, rs = -1;
        if(root.left != null && root.left.val != root.val)  ls = root.left.val;
        else    ls = findSecondMinimumValue(root.left);
        if(root.right != null && root.right.val != root.val)  rs = root.right.val;
        else    rs = findSecondMinimumValue(root.right);
        
        if(ls == -1 || rs == -1)    return Math.max(ls, rs);
        return Math.min(ls, rs);
    }
}