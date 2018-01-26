/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // find the one in the mid as root
        if(head == null)    return null;
        return traverse(head, null);
    }
    
    public TreeNode traverse(ListNode head, ListNode tail) {
        // can't reach tail
        if(head == tail)    return null;
        ListNode slow = head, fast = head;
        // find mid
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = traverse(head, slow);
        node.right = traverse(slow.next, tail);
        return node;
    }
}