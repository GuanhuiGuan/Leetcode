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
    int maxCount = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        subsum(root);
        if(map.size() == 0) return new int[0];
        List<Integer> list = new ArrayList<>();
        
        for(int key: map.keySet()) {
            if(map.get(key) == maxCount)    list.add(key);
        }
        int[] re = new int[list.size()];
        for(int i = 0; i < list.size(); i++)    re[i] = list.get(i);
        return re;
    }
    
    public int subsum(TreeNode node) {
        if(node == null)    return 0;
        int sum = node.val;
        sum += subsum(node.left) + subsum(node.right);
        map.put(sum, map.getOrDefault(sum, 0)+1);
        // keep track of max count
        maxCount = Math.max(maxCount, map.get(sum));
        return sum;
    }
}