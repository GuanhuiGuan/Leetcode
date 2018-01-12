/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // next lvl head; next lvl leading node; cur lvl leading node
        TreeLinkNode head = null, tail = null, cur = root;
        while(cur != null) {
            // lvl traversal
            while(cur != null) {
                // traverse horizontally in cur lvl
                // if tail null(start of lvl), initialize head; else point tail.next; move tail
                // left child
                if(cur.left != null) {
                    if(tail == null) {
                        head = cur.left;
                    }
                    else {
                        tail.next = cur.left;
                    }
                    tail = cur.left;
                }
                
                // right child
                if(cur.right != null) {
                    if(tail == null) {
                        head = cur.right;
                    }
                    else {
                        tail.next = cur.right;
                    }
                    tail = cur.right;
                }
                cur = cur.next;
            }
            
            // to next lvl
            cur = head;
            head = null;
            tail = null;
        }
    }
}