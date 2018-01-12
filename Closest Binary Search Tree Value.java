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
    public int closestValue(TreeNode root, double target) {
        int cur = root.val;
        // BST traits, decide where to go next
        TreeNode next = null;
        if(target < cur)    next = root.left;
        else    next = root.right;
        
        // choose cur or next
        if(next == null)    return cur;
        int nval = closestValue(next, target);
        return (Math.abs(target-nval) < Math.abs(target-cur))? nval: cur;
    }
}

// class Solution {
//     int re;
//     double gap;
    
//     public int closestValue(TreeNode root, double target) {
//         re = root.val;
//         gap = Math.abs(target-root.val);
//         traverse(root, target);
//         return re;
//     }
    
//     public void traverse(TreeNode node, double target) {
//         if(node == null)    return;
//         if(Math.abs(target-node.val) < gap) {
//             re = node.val;
//             gap = Math.abs(target-node.val);
//         }
//         traverse(node.left, target);
//         traverse(node.right, target);
//     }
// }