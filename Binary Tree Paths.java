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
    List<String> res = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)    return res;
        dfs(root, "");
        return res;
    }
    
    public void dfs(TreeNode node, String path) {
        String newPath = path + node.val;
        if(node.left == null && node.right == null) {
            res.add(newPath);
            return;
        }
        if(node.left != null) {
            dfs(node.left, newPath + "->");
        }
        if(node.right != null) {
            dfs(node.right, newPath + "->");
        }
    }
}