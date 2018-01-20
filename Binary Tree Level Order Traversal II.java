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
    // BFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> re = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)    return re;
        q.offer(root);
        
        while(!q.isEmpty()) {
            // add nodes lvl by lvl
            int size = q.size();
            List<Integer> lvl = new ArrayList<>();
            for(int k = 0; k < size; k++) {
                TreeNode node = q.poll();
                if(node.left != null)   q.offer(node.left);
                if(node.right != null)  q.offer(node.right);
                lvl.add(node.val);
            }
            re.add(0, lvl);
        }
        return re;
    }
    
//     // DFS, insert new line at first, add at size-1-lvl
//     List<List<Integer>> re = new ArrayList<>();
    
//     public List<List<Integer>> levelOrderBottom(TreeNode root) {
//         DFS(root, 0);
//         return re;
//     }
    
//     public void DFS(TreeNode node, int lvl) {
//         if(node == null)    return;
        
//         if(lvl >= re.size()) re.add(0, new ArrayList<>());
//         DFS(node.left, lvl+1);
//         DFS(node.right, lvl+1);
//         re.get(re.size()-1-lvl).add(node.val);
//     }
}