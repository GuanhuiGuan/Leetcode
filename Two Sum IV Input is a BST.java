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
    
    List<Integer> list = new ArrayList<>();
    
    //** Get all elements in sorted array with inorder walk, and search from both ends
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        if(list.isEmpty())  return false;
        int i = 0, j = list.size()-1;
        while(i < j) {
            int v1 = list.get(i), v2 = list.get(j);
            if(v1 == k - v2)    return true;
            else if(v1 < k - v2)    i++;
            else    j--;
        }
        return false;
    }
    
    public void inorder(TreeNode node) {
        if(node == null)    return;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
}