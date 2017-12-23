/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    // use stack to meet the space requirement
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        goLeftMost(root);
    }
    
    // push all on the left lane of curr node
    public void goLeftMost(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // search if more on the right child
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        goLeftMost(node.right);
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */