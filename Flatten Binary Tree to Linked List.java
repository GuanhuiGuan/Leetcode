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
    TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        // reversed preorder, link right to left before left is done
        if(root == null)    return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
    
//     public TreeNode traverse(TreeNode node) {
//         if(node == null)    return null;
//         TreeNode ln = traverse(node.left);
//         node.left = null;
//         TreeNode rn = traverse(node.right);
        
//         if(ln != null) {
//             TreeNode newNode = node;
//             while(ln != null) {
//                 newNode.right = ln;
//                 ln = ln.right;
//                 newNode = newNode.right;
//             }
//             newNode.right = rn;
//         }
//         else    node.right = rn;
//         return node;
//     }
}