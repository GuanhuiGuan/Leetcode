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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // Merge into one tree instead of creating a new one
        if(t1 == null)  return t2;
        if(t2 == null)  return t1;
        
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
        
        // if(t1 == null && t2 == null)    return null;
        // int v1 = t1 == null? 0: t1.val;
        // int v2 = t2 == null? 0: t2.val;
        // TreeNode node = new TreeNode(v1 + v2);
        // node.left = mergeTrees(t1 == null? null: t1.left, t2 == null? null: t2.left);
        // node.right = mergeTrees(t1 == null? null: t1.right, t2 == null? null: t2.right);
        // return node;
    }
}