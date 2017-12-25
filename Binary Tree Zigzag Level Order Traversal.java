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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(root, 1, lists);
        return lists;
    }
    
    public void helper(TreeNode node, int lvl, List<List<Integer>> lists){
        if(node == null)    return;
        if(lists.size() < lvl){
            lists.add(new ArrayList<>());
        }
        // even: add in the front; odd: in the back; list at the lvl
        if(lvl%2 == 0)  lists.get(lvl-1).add(0, node.val);
        else    lists.get(lvl-1).add(node.val);
        
        helper(node.left, lvl+1, lists);
        helper(node.right, lvl+1, lists);
    }
}