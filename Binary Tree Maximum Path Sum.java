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
    int maxS = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int m = pathDiv(root);
        return Math.max(maxS, m);
    }
    
    public int pathDiv(TreeNode node){
        if(node == null)    return 0;
        // get positive value going down either path
        int left = Math.max(0, pathDiv(node.left));
        int right = Math.max(0, pathDiv(node.right));
        // calculate the path left->node->right
        maxS = Math.max(maxS, left+right+node.val);
        // return value going down the path with max value
        return node.val + Math.max(left, right);
    }
}