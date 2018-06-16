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
        // Level by level traversal, two lvls at a time
        
        TreeLinkNode cur = root, nHead = null, nTail = null;
        
        // outer loop for going next level
        while(cur != null) {
            // inner loop for moving along current level
            while(cur != null) {
                // left node
                if(cur.left != null) {
                    // if start of lvl, mark start of next lvl with nHead
                    if(nTail == null)   nHead = cur.left;
                    // otherwise, connect next node with nTail
                    else    nTail.next = cur.left;
                    // move horizontally
                    nTail = cur.left;
                }
                
                // right node
                if(cur.right != null) {
                    // if start of lvl, mark start of next lvl with nHead
                    if(nTail == null)   nHead = cur.right;
                    // otherwise, connect next node with nTail
                    else    nTail.next = cur.right;
                    // move horizontally
                    nTail = cur.right;
                }
                
                // cur move
                cur = cur.next;
            }
            // traverse to next level
            cur = nHead;
            nHead = null;
            nTail = null;
        }
    }
}