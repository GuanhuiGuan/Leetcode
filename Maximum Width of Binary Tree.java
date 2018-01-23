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
    List<Integer> start = new ArrayList<>(), end = new ArrayList<>();
    
    public int widthOfBinaryTree(TreeNode root) {
        return lvlTraverse(root, 0, 1);
    }
    
    // return the max width of current lvl
    public int lvlTraverse(TreeNode node, int lvl, int order) {
        if(node == null)   return 0;
        if(start.size() == lvl) {
            start.add(order);
            end.add(order);
        }
        // only update end, because start only records the smallest one, and we go left first
        else    end.set(lvl, order);
        
        // find current width
        int width = end.get(lvl) - start.get(lvl) + 1;
        int left = lvlTraverse(node.left, lvl+1, 2*order);
        int right = lvlTraverse(node.right, lvl+1, 2*order+1);
        return Math.max(width, Math.max(left, right));
    }
}