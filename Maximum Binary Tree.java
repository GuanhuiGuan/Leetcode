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
        if(nums.length == 0)    return null;
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[index] < nums[i]) {
                index = i;
            }
        }
        TreeNode node = new TreeNode(nums[index]);
        TreeNode ln = constructMaximumBinaryTree(getSubArray(nums, 0, index));
        TreeNode rn = constructMaximumBinaryTree(getSubArray(nums, index+1, nums.length));
        node.left = ln;
        node.right = rn;
        return node;
    }
    
    public int[] getSubArray(int[] nums, int i, int j) {
        int n = j-i;
        int[] re = new int[n];
        for(int k = 0; k < n; k++) {
            re[k] = nums[i+k];
        }
        return re;
    }
}