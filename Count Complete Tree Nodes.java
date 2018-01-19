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
    // O(log(n)*log(n)), iterative and recursive
    public int countNodes(TreeNode root) {
        if(root == null)    return 0;
        // get left height and right height
        int height = 0;
        TreeNode ln = root, rn = root;
        // right hit null faster
        while(rn != null) {
            ln = ln.left;
            rn = rn.right;
            height++;
        }
        
        // if complete, 2^h-1
        if(ln == null)    return (1<<height) - 1;
        // for this recursion, at least one subtree would be complete and terminate
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    // // O(n)
    // public int countNodes(TreeNode root) {
    //     if(root == null)    return 0;
    //     return 1 + countNodes(root.left) + countNodes(root.right);
    // }
}