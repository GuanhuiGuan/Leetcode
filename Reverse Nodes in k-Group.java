/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dr = new ListNode(0);
        dr.next = head;
        
        // find the length of the list
        int n = 0;
        for(ListNode end = head; end != null; n++, end = end.next);
        // n is the length
        
        // reverse all sublists of length k
        for(ListNode prev = dr, cur = head, next = cur.next; n >= k; n -= k) {
            // only k-1 reversions
            for(int i = 1; i < k; i++) {
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            prev = cur;
            cur = cur.next;
            next = cur.next;
        }
        
        return dr.next;
    }
}