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
    // iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> re = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)    return re;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            re.add(node.val);
            if(node.right != null)  stack.push(node.right);
            if(node.left != null)  stack.push(node.left);
        }
        return re;
    }
    
//     // recursive
//     List<Integer> re = new ArrayList<>();
    
//     public List<Integer> preorderTraversal(TreeNode root) {
//         traverse(root);
//         return re;
//     }
    
//     public void traverse(TreeNode node) {
//         if(node == null)    return;
//         re.add(node.val);
//         traverse(node.left);
//         traverse(node.right);
//     }
}