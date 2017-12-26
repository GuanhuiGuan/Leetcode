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
    List<Integer> re;
    
    public List<Integer> largestValues(TreeNode root) {
        re = new ArrayList<>();
        helper(root, 1);
        return re;
    }
    
    public void helper(TreeNode node, int lvl){
        if(node == null)    return;
        if(lvl > re.size()) re.add(node.val);
        else{
            re.set(lvl-1, Math.max(re.get(lvl-1), node.val));
        }
        helper(node.left, lvl+1);
        helper(node.right, lvl+1);
    }
}