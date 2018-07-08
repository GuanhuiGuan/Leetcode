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
    public void recoverTree(TreeNode root) {
        // inOrderTraversal(root);
        morrisTraversal(root);
    }
    
    private TreeNode fst = null, snd = null, prev = new TreeNode(Integer.MIN_VALUE);
    
    private void morrisTraversal(TreeNode root) {
        // O(1) Space traversal
        // Inorder version here, could be modified to preorder version with slight change
        // Use morPrev to thread child and parent
        TreeNode cur = root, morPrev = null;
        while(cur != null) {
            // Process current and move to right hand side
            if(cur.left == null) {
                process(cur);
                cur = cur.right;
            }
            // Continue left side
            else {
                // Find predecessor of cur
                morPrev = findPredecessor(cur.left, cur);
                
                // If predecessor's right child is null, set thread from right child to parent and keep going left
                if(morPrev.right == null) {
                    morPrev.right = cur;
                    // process(cur);        // If preorder
                    cur = cur.left;
                }
                // Else, left is visited, then visit current and then go right
                else {
                    morPrev.right = null;       // Recover tree struct
                    process(cur);       // If inorder
                    cur = cur.right;
                }
            }
        }
        
        swap();
    }
    
    private TreeNode findPredecessor(TreeNode morPrev, TreeNode cur) {
        while(morPrev.right != null && morPrev.right != cur)    morPrev = morPrev.right;
        return morPrev;
    }
    
    private void process(TreeNode cur) {
        if(fst == null && prev.val > cur.val)   fst = prev;
        if(fst != null && prev.val > cur.val)   snd = cur;
        prev = cur;
    }
    
    private void swap() {
        int t = fst.val;
        fst.val = snd.val;
        snd.val = t;
    }
    
    // ******************************************************************
    
    private void inOrderTraversal(TreeNode root) {
        // Use inorder traversal to track first and second wrong nodes by comparing them to previous node
        // Then swap them
        // O(n) space on Stack
        
        // Traverse to find first and second
        inOrder(root);
        
        // Swap
        int t = fst.val;
        fst.val = snd.val;
        snd.val = t;
    }
    
    private void inOrder(TreeNode root) {
        if(root == null)    return;
        
        // Left
        inOrder(root.left);
        
        // Cur(Only one mistake)
        // First wrong one: assign prev
        if(fst == null && prev.val > root.val)  fst = prev;
        // Second wrong one: assign root
        if(fst != null && prev.val > root.val) snd = root;
        
        prev = root;
        
        // Right
        inOrder(root.right);
    }
}