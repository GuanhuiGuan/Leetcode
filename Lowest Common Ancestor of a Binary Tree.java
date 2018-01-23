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
    // recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode ln = lowestCommonAncestor(root.left, p, q);
        TreeNode rn = lowestCommonAncestor(root.right, p, q);
        if(ln == null && rn == null)    return null;
        if(ln == null)  return rn;
        if(rn == null)  return ln;
        return root;
    }
    // iteration
    class LinkNode {
        TreeNode node;
        LinkNode parent;
        boolean visited = false;
        List<TreeNode> result = new ArrayList<>();
        public LinkNode(LinkNode p, TreeNode n) {
            parent = p;
            node = n;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkNode dr = new LinkNode(null, null);
        LinkNode r = new LinkNode(dr, root);
        Stack<LinkNode> stack = new Stack<>();
        stack.push(r);
        
        while(!stack.isEmpty()) {
            LinkNode node = stack.peek();
            LinkNode parent = node.parent;
            TreeNode cur = node.node;
            
            // reach leaf or target: add result to parent, done with the node
            if(cur == null || cur == p || cur == q) {
                parent.result.add(cur);
                stack.pop();
            }
            // not visited: insert children, right first because it's a stack
            else if(!node.visited) {
                node.visited = true;
                LinkNode ln = new LinkNode(node, cur.left);
                LinkNode rn = new LinkNode(node, cur.right);
                stack.push(rn);
                stack.push(ln);
            }
            // visited: result list has two results, update parent's result
            else if(node.visited){
                TreeNode ln = node.result.get(0);
                TreeNode rn = node.result.get(1);
                if(ln != null && rn != null)    parent.result.add(cur);
                else if(ln != null) parent.result.add(ln);
                else    parent.result.add(rn);
                // done with this node
                stack.pop();
            }
        }
        return dr.result.get(0);
    }
}