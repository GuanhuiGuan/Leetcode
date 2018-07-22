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
        return height(root) != -1;
    }
    
    private int height(TreeNode node) {
        // -1 means unbalanced
        if(node == null)    return 0;
        int lh = height(node.left), rh = height(node.right);
        // If subtree unbalanced
        if(lh == -1)    return -1;
        if(rh == -1)    return -1;
        // If current unbalanced
        if(Math.abs(lh - rh) > 1)   return -1;
        // Else, return correct height
        else    return Math.max(lh, rh) + 1;
    }
}