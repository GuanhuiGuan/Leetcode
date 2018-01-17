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
    // preorder

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        String re = sb.toString();
        return re.substring(0, re.length()-1);
    }
    
    public void buildString(TreeNode node, StringBuilder sb) {
        if(node == null)    sb.append("null,");
        else {
            sb.append(node.val + ",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return buildTree(q);
    }
    
    public TreeNode buildTree(Queue<String> q) {
        if(q.isEmpty()) return null;
        String s = q.poll();
        if(s.equals("null"))    return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = buildTree(q);
        node.right = buildTree(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));