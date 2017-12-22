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
        int scMin = helper(root);
        if(scMin == root.val)   return -1;
        return scMin;
    }
    
    public int helper(TreeNode node){
        // no children
        if(node.left == null)   return node.val;
        // has children
        // same as parent
        int leftV = node.val;
        int rightV = node.val;
        
        if(node.val == node.left.val){
            leftV = helper(node.left);
        }
        else{
            leftV = node.left.val;
        }
        if(node.val == node.right.val){
            rightV = helper(node.right);
        }
        else{
            rightV = node.right.val;
        }
        if(leftV == node.val)   return rightV;
        if(rightV == node.val)  return leftV;
        return Math.min(leftV, rightV);
            
    }
}