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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(root, lists, 1);
        return lists;
    }
    
    public void helper(TreeNode node, List<List<Integer>> lists, int lvl){
        if(node == null)    return;
        if(lvl > lists.size()){
            lists.add(new ArrayList<>());
        }
        lists.get(lvl-1).add(node.val);
        helper(node.left, lists, lvl+1);
        helper(node.right, lists, lvl+1);
    }
}