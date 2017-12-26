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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(root, lists);
        return lists;
    }
    
    // find the height of the node
    public int helper(TreeNode node, List<List<Integer>> lists){
        // negative height
        if(node == null)    return -1;
        // height, start from 0(leaves)
        int height = 1 + Math.max(helper(node.left, lists), helper(node.right, lists));
        // reach new height: add list
        if(lists.size() <= height){
            lists.add(new ArrayList<>());
        }
        // add val to list of current height
        lists.get(height).add(node.val);
        
        return height;
    }
}