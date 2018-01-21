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
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> re = new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // postorder, use string to save the structure
        traverse(root);
        return re;
    }
    
    public String traverse(TreeNode node) {
        // postorder traversal, save structure and find in map
        if(node == null)    return "X";
        String stt = node.val + "+" + traverse(node.left) + "+" + traverse(node.right);
        if(map.containsKey(stt)) {
            // ==1 avoid duplicate results
            if(map.get(stt) == 1)   re.add(node);
            map.put(stt, map.get(stt)+1);
        }
        else    map.put(stt, 1);
        return stt;
    }
}