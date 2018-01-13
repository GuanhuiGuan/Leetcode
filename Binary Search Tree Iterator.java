/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// stack has O(h) complexity
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    
    public void pushLeft(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        pushLeft(top.right);
        return top.val;
    }
}

// // queue has O(n) space complexity
// public class BSTIterator {
//     Queue<Integer> q = new LinkedList<>();

//     public BSTIterator(TreeNode root) {
//         traverse(root);
//     }
    
//     public void traverse(TreeNode node) {
//         if(node == null)    return;
//         traverse(node.left);
//         q.offer(node.val);
//         traverse(node.right);
//     }

//     /** @return whether we have a next smallest number */
//     public boolean hasNext() {
//         return !q.isEmpty();
//     }

//     /** @return the next smallest number */
//     public int next() {
//         return q.poll();
//     }
// }

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */