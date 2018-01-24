/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)    return;
        // 3 steps, find mid->reverse back->insert back half
        // always save nodes at the back first, then have other operations
        // find mid for odd, preOdd for even
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the back half, mid is the node in mid or at left of mid
        ListNode preMid = slow, pre = preMid.next;
        while(pre.next != null) {
            ListNode cur = pre.next;
            pre.next = cur.next;
            cur.next = preMid.next;
            preMid.next = cur;
        }
        
        // insert second half into first half, those behind preMid(p2)
        ListNode p1 = head, p2 = preMid.next;
        while(p1 != preMid) {
            preMid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p1.next.next;
            p2 = preMid.next;
        }
    }
}