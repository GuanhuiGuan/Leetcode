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
    // post order; array as object
    
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)    return 0;
        int[] max = new int[1];
        dfs(root, max);
        return max[0];
    }
    
    public int dfs(TreeNode node, int[] max) {
        // find maxUni starting from left/right node
        int stAtLeft = node.left == null? 0: dfs(node.left, max);
        int stAtRight = node.right == null? 0: dfs(node.right, max);
        // find maxUni starting at this node going left/right
        int goLeft = (node.left != null && node.left.val == node.val)?
            stAtLeft+1: 0;
        int goRight = (node.right != null && node.right.val == node.val)?
            stAtRight+1: 0;
        // update max and return maxUni starting at this node
        // max path could connect left and right
        max[0] = Math.max(max[0], goLeft+goRight);
        return Math.max(goLeft, goRight);
    }
}