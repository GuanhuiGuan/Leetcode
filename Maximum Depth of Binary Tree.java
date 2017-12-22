/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Improved
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)    return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

//____________________________
class Solution {
    public int maxDepth(TreeNode root) {
        return search(root, 0);
    }
    
    public int search(TreeNode node, int depth){
        if(node == null)    return depth;
        depth++;
        int leftDepth = depth;
        int rightDepth = depth;
        if(node.left != null)   leftDepth = search(node.left, depth);
        if(node.right != null)   rightDepth = search(node.right, depth);
        return Math.max(leftDepth, rightDepth);
    }
}