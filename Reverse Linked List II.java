/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 4 pointers: dRoot, pre, start, rev
        ListNode dRoot = new ListNode(0);
        dRoot.next = head;
        
        // the root before the reversed substring
        ListNode pre = dRoot;
        for(int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        
        // only reverse(insert) one node(rev) at a time
        // start: the node right before the node will be reversed
        // rev: the node reversed, will be pre.next
        ListNode start = pre.next, rev = start.next;
        for(int i = 0; i < n-m; i++) {
            // rev.next: the next node will be reversed
            start.next = rev.next;
            // insert rev to the position behind pre
            rev.next = pre.next;
            pre.next = rev;
            // go to next reverse position
            rev = start.next;
        }
        
        return dRoot.next;
    }
}