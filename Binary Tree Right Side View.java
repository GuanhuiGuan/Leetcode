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
    List<Integer> list;
    
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        search(root, 1);
        return list;
    }
    
    public void search(TreeNode node, int lvl){
        if(node == null)    return;
        if(lvl > list.size()){
            list.add(node.val);
        }
        search(node.right, lvl+1);
        search(node.left, lvl+1);
    }
}