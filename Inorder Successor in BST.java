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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)    return root;
        // it would be on the right anyway
        if(root.val <= p.val){
            return inorderSuccessor(root.right, p);
        }
        else{
            TreeNode leftC = inorderSuccessor(root.left, p);
            return leftC == null? root: leftC;
        }
    }
    
    /*
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if(root == null)    return root;
        // it would be on the left anyway
        if(root.val >= p.val){
            return inorderPredecessor(root.left, p);
        }
        else{
            TreeNode rightC = inorderSuccessor(root.right, p);
            return rightC == null? root: rightC;
        }
    }
    */
}