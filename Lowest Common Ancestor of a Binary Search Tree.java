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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // use traits of BST
        while(root != null && (root.val - p.val)*(root.val - q.val) > 0){
            // greater than both
            if(root.val - p.val > 0)    root = root.left;
            // smaller than both
            else    root = root.right;
        }
        return root;
        
        
//         if(root == null)    return null;
//         if(root == p || root == q)  return root;
        
//         TreeNode ln = lowestCommonAncestor(root.left, p, q);
//         TreeNode rn = lowestCommonAncestor(root.right, p, q);
        
//         if(ln == null && rn == null)   return null;
//         if(ln != null && rn != null)    return root;
//         if(ln != null)  return ln;
//         else    return rn;
    }
}