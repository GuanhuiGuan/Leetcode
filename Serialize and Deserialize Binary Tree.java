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
    private static final String splitter = ",";
    private static final String Null = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        srHelper(root, sb);
        return sb.toString();
    }
    
    public void srHelper(TreeNode node, StringBuilder sb){
        if(node == null)    sb.append("X").append(splitter);
        else{
            sb.append(node.val).append(splitter);
            srHelper(node.left, sb);
            srHelper(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(splitter)));
        return dsHelper(q);
    }
    
    public TreeNode dsHelper(Deque<String> q){
        String s = q.remove();
        if(s.equals(Null))  return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = dsHelper(q);
        node.right = dsHelper(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));