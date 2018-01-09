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
    Map<Integer, Integer> map;
    boolean twoSum = false;
    
    public boolean findTarget(TreeNode root, int k) {
        map = new HashMap<>();
        search(root, k);
        return twoSum;
    }
    
    public void search(TreeNode node, int k) {
        if(node == null)    return;
        if(map.containsKey(node.val)) {
            twoSum = true;
            return;
        }
        map.put(k-node.val, node.val);
        search(node.left, k);
        search(node.right, k);
    }
}