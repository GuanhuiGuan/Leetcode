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
    // sum unchanged, try to use every node as starting node
    public int pathSum(TreeNode root, int sum) {
        if(root == null)    return 0;
        return search(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    // sum decrement
    public int search(TreeNode node, int sum) {
        if(node == null)    return 0;
        int cnt = (node.val == sum)? 1: 0;
        return cnt + search(node.left, sum-node.val) + search(node.right, sum-node.val);
    }
}