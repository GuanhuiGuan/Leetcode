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
    public int kthSmallest(TreeNode root, int k) {
        // Binary search
        // find num count smaller than current node
        int smaller = count(root.left);
        if(k <= smaller)    return kthSmallest(root.left, k);
        if(k > smaller+1)   return kthSmallest(root.right, k-smaller-1); // the 1 is for current node
        return root.val;
    }
    
    public int count(TreeNode node) {
        if(node == null)    return 0;
        return 1+count(node.left)+count(node.right);
    }
}