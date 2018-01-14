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
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        // bottom up find height
        height(root);
        return re;
    }
    
    public int height(TreeNode node) {
        if(node == null)    return 0;
        int h = 1 + Math.max(height(node.left), height(node.right));
        if(h > re.size())   re.add(new ArrayList<>());
        re.get(h-1).add(node.val);
        return h;
    }
}