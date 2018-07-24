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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        if(d < 1 || root == null)   return root;
        
        root.left = walk(root.left, true, 2, v, d);
        root.right = walk(root.right, false, 2, v, d);
        return root;
    }
    
    private TreeNode walk(TreeNode node, boolean isLeft, int depth, int v, int d) {
        // Node is the original node at depth
        // Even if node is null, can insert
        if(depth == d) {
            TreeNode insert = new TreeNode(v);
            if(isLeft)  insert.left = node;
            else    insert.right = node;
            return insert;
        }
        
        if(node == null)    return null;
        node.left = walk(node.left, true, depth+1, v, d);
        node.right = walk(node.right, false, depth+1, v, d);
        return node;
    }
}