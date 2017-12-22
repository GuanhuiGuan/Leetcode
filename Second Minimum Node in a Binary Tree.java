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
    public int findSecondMinimumValue(TreeNode root) {
        //if same as the root, no second minimum
        if(root == null)    return -1;
        // no children
        // it eliminates the case that the path shares the same val till the end
        if(root.left == null)   return -1;
        // has children
        // same as parent or not
        int leftV = root.left.val;
        int rightV = root.right.val;
        
        // traverse downwards if same
        if(root.val == root.left.val){
            leftV = findSecondMinimumValue(root.left);
        }
        if(root.val == root.right.val){
            rightV = findSecondMinimumValue(root.right);
        }
        
        // select output
        if(leftV == -1 && rightV == -1)   return -1;
        else if(leftV == -1){
            return rightV;
        }
        else if(rightV == -1){
            return leftV;
        }
        else{
            return Math.min(leftV, rightV);
        }
    }
}