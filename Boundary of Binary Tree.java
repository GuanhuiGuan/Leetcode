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
    
    private List<Integer> res;
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // Check left boundary, leaves and right boundary
        res = new ArrayList<>();
        if(root == null)    return res;
        
        res.add(root.val);
        leftBound(root.left);
        leaf(root.left);
        leaf(root.right);
        rightBound(root.right);
        
        return res;
    }
    
    private void leftBound(TreeNode node) {
        // Top down for anti-clockwise
        if(node == null || isLeaf(node))    return;
        res.add(node.val);
        if(node.left != null)   leftBound(node.left);
        else    leftBound(node.right);
    }
    
    private void rightBound(TreeNode node) {
        // Bottom up for anti-clockwise
        if(node == null || isLeaf(node))    return;
        if(node.right != null)   rightBound(node.right);
        else    rightBound(node.left);
        res.add(node.val);
    }
    
    private void leaf(TreeNode node) {
        if(node == null)    return;
        if(isLeaf(node))    res.add(node.val);
        else {
            leaf(node.left);
            leaf(node.right);
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}