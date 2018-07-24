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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // return divide(nums, 0, nums.length-1);
        return deque(nums);
    }
    
    private TreeNode deque(int[] nums) {
        // O(n), deque stores nodes with descending values
        Deque<TreeNode> deq = new LinkedList<>();
        for(int num: nums) {
            TreeNode node = new TreeNode(num);
            
            // Get the max possible left node(earlier popped nodes are already connected to even earlier nodes)
            while(!deq.isEmpty() && deq.peek().val < num)   node.left = deq.pop();
            
            // If there're still earlier (greater) nodes, link current node
            if(!deq.isEmpty())  deq.peek().right = node;
            
            // Insert current node
            deq.push(node);
        }
        return deq.isEmpty()? null: deq.removeLast();
    }
    
    private TreeNode divide(int[] nums, int s, int e) {
        if(s > e)   return null;
        if(s == e)  return new TreeNode(nums[s]);
        
        int index = 0, max = Integer.MIN_VALUE;
        for(int i = s; i <= e; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = divide(nums, s, index-1);
        node.right = divide(nums, index+1, e);
        return node;
    }
}