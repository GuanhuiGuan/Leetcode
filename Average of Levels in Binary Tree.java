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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> re = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)    return re;
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            for(int k = 0; k < size; k++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null)   q.offer(node.left);
                if(node.right != null)  q.offer(node.right);
            }
            re.add(sum/size);
        }
        return re;
    }
    
    
//     // DFS
//     List<List<Integer>> lvls = new ArrayList<>();
    
//     public List<Double> averageOfLevels(TreeNode root) {
//         walk(root, 0);
//         List<Double> re = new ArrayList<>();
//         for(int i = 0; i < lvls.size(); i++) {
//             double ave = 0;
//             for(int v: lvls.get(i)) ave += v;
//             ave /= lvls.get(i).size();
//             re.add(ave);
//         }
//         return re;
//     }
    
//     public void walk(TreeNode node, int lvl) {
//         if(node == null)    return;
//         if(lvl >= lvls.size())  lvls.add(new ArrayList<>());
//         lvls.get(lvl).add(node.val);
//         walk(node.left, lvl+1);
//         walk(node.right, lvl+1);
//     }
}