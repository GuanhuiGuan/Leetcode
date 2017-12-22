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
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode lNode, TreeNode rNode){
        // if at least one of them null: check if same
        if(lNode == null || rNode == null)  return lNode == rNode;
        // if not null: check if same value
        if(lNode.val != rNode.val)  return false;
        // if true: goes both outside and inside to check symmetry
        return helper(lNode.left, rNode.right) && helper(lNode.right, rNode.left);
    }
}