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
    List<String> re = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)    return re;
        dfs(root, "");
        return re;
    }
    
    public void dfs(TreeNode node, String s) {
        if(!s.equals(""))    s += "->";
        s += node.val;
        if(node.left == null && node.right == null) {
            re.add(s);
            return;
        }
        if(node.left != null)   dfs(node.left, s);
        if(node.right != null)  dfs(node.right, s);
    }
}