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
    
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    List<Integer> list = new ArrayList<>();
    
    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)    res[i] = list.get(i);
        return res;
    }
    
    private int sum(TreeNode node) {
        if(node == null)    return 0;
        int ls = sum(node.left), rs = sum(node.right);
        int sum = ls + rs + node.val;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        
        int v = map.get(sum);
        if(v > max) {
            max = v;
            list = new ArrayList<>();
            list.add(sum);
        }
        else if(v == max) {
            list.add(sum);
        }
        
        return sum;
    }
}