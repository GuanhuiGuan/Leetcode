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
    int maxL = 0;
    
    public int longestConsecutive(TreeNode root) {
        if(root == null)    return 0;
        search(root, root.val, 1);
        return maxL;
    }
    
    public void search(TreeNode node, int pre, int cnt) {
        if(node == null)  return;
        if(node.val == pre+1)   cnt++;
        else    cnt = 1;
        maxL = Math.max(maxL, cnt);
        search(node.left, node.val, cnt);
        search(node.right, node.val, cnt);
    }
}