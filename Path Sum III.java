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
    // 2 recursions, in 2 methods
    
    public int pathSum(TreeNode root, int sum) {
        // recurse to find sum starting from every node
        if(root == null)    return 0;
        return traverse(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int traverse(TreeNode node, int sum) {
        // recurse to find path starting from some parent
        if(node == null)    return 0;
        int count = sum == node.val? 1: 0;
        return count + traverse(node.left, sum-node.val) + traverse(node.right, sum-node.val);
    }
}