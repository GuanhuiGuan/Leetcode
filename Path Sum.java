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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)    return false;
        if(root.left == null && root.right == null && root.val == sum)  return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
    
//     // original
//     boolean found = false;
    
//     public boolean hasPathSum(TreeNode root, int sum) {
//         search(root, 0, sum);
//         return found;
//     }
    
//     public void search(TreeNode node, int cnt, int sum) {
//         if(node == null)    return;
//         if(node.val + cnt == sum){
//             if(node.left == null && node.right == null) {
//                 found = true;
//             }
//         }
//         cnt += node.val;
//         search(node.left, cnt, sum);
//         search(node.right, cnt, sum);
//     }
}