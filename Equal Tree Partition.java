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
    private Map<Integer, Integer> map = new HashMap<>();
    
    public boolean checkEqualTree(TreeNode root) {
        // Record total sum and sum for every subtree
        // Check if sum/2 exists
        int total = sum(root);
        // Sum==0: check if subtree sum == 0 at least twice
        if(total == 0)  return map.getOrDefault(total, 0) >= 2;
        // Otherwise, has to be even and exist half
        return total%2 == 0 && map.containsKey(total/2);
    }
    
    private int sum(TreeNode node) {
        if(node == null)    return 0;
        int s = node.val + sum(node.left) + sum(node.right);
        map.put(s, map.getOrDefault(s, 0)+1);
        return s;
    }
}