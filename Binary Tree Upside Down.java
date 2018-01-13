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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null)    return null;
        TreeNode newHead = upsideDownBinaryTree(root.left);
        if(newHead == null) return root;
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        // they would be reconnected in upper lvls
        // return the true new root, thus no operation on it unless the bottom lvl
        return newHead;
    }
}