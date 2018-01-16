/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // preorder walk: node->left to the end->right
        // so that it could be better rebuilt(not like what's in problem description)
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sh(root, sb);
        String s = sb.toString();
        s = s.substring(0, s.length()-1);
        return s+"]";
    }
    
    public void sh(TreeNode node, StringBuilder sb) {
        if(node == null)    sb.append("null,");
        else {
            sb.append(node.val + ",");
            sh(node.left, sb);
            sh(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // preorder, always recurse on left first
        data = data.substring(1, data.length()-1);
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return dh(q);
    }
    
    public TreeNode dh(Queue<String> q) {
        if(q.isEmpty()) return null;
        String s = q.poll();
        if(s.equals("null"))    return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = dh(q);
        node.right = dh(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));