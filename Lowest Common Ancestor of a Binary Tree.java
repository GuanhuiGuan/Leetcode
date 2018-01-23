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
    // // recursion
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if(root == null || root == p || root == q)  return root;
    //     TreeNode ln = lowestCommonAncestor(root.left, p, q);
    //     TreeNode rn = lowestCommonAncestor(root.right, p, q);
    //     if(ln == null && rn == null)    return null;
    //     if(ln == null)  return rn;
    //     if(rn == null)  return ln;
    //     return root;
    // }
    
    // iteration
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        // the map to store the <node, node's parent>
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        if(root == null)    return root;
        stack.push(root);
        parent.put(root, null);
        
        // find the parent of p and q
        while(!(parent.containsKey(p) && parent.containsKey(q))) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                stack.push(node.left);
                parent.put(node.left, node);
            }
            if(node.right != null) {
                stack.push(node.right);
                parent.put(node.right, node);
            }
        }
        
        // find all parents of p
        Set<TreeNode> parent_of_p = new HashSet<>();
        while(p != null) {
            parent_of_p.add(p);
            p = parent.get(p);
        }
        // find the closest parent of q in the parent_of_p
        while(!parent_of_p.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}