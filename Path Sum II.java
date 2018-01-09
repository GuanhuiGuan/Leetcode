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
    List<List<Integer>> re = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        search(root, sum, new ArrayList<>());
        return re;
    }
    
    public void search(TreeNode node, int sum, List<Integer> path) {
        if(node == null)    return;
        path.add(node.val);
        if(node.left == null && node.right == null && node.val == sum)  re.add(path);
        
        List<Integer> copy = new ArrayList<>(path);
        search(node.left, sum-node.val, path);
        search(node.right, sum-node.val, copy);
    }
}