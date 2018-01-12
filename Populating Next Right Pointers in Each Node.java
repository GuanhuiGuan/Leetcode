/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null)   return;
        helper(root.left, root.right);
    }
    
    public void helper(TreeLinkNode n1, TreeLinkNode n2) {
        n1.next = n2;
        if(n1.left != null) {
            helper(n1.left, n1.right);
            helper(n1.right, n2.left);
            helper(n2.left, n2.right);
        }
    }
}