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
    
    public List<TreeNode> generateTrees(int n) {
        // (1 -> i-1)--i--(i+1 -> n)
        if(n == 0)  return new ArrayList<>();
        return dfs(1, n);
    }
    
    public List<TreeNode> dfs(int i, int j) {
        List<TreeNode> list = new ArrayList<>();
        // watch the corner cases
        if(j < i) {
            list.add(null);
            return list;
        }
        
        for(int k = i; k <= j; k++) {
            List<TreeNode> ll = dfs(i, k-1);
            List<TreeNode> rl = dfs(k+1, j);
            for(TreeNode ln: ll) {
                for(TreeNode rn: rl) {
                    TreeNode node = new TreeNode(k);
                    node.left = ln;
                    node.right = rn;
                    list.add(node);
                }
            }
        }
        return list;
    }
}