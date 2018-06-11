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
        // find the k-size sublist
        if(head == null)    return head;
        ListNode node = head;
        int i = 1;
        for(; node.next != null && i < k; i++) {
            node = node.next;
        }
        if(i < k)   return head;
        
        // split and reverse current, recurse on the latter list
        ListNode next = node.next;
        node.next = null;
        ListNode newHead = reverse(head), newTail = reverseKGroup(next, k);
        // ListNode newHead = reverse(head, null), newTail = reverseKGroup(next, k);
        
        // reconnect
        ListNode newHeadEnd = findEnd(head);
        newHeadEnd.next = newTail;
        return newHead;
    }
    
    public ListNode reverse(ListNode head) {
        // iterative
        ListNode dr = new ListNode(0);
        while(head != null) {
            ListNode next = head.next;
            head.next = dr.next;
            dr.next = head;
            head = next;
        }
        return dr.next;
    }
    
    public ListNode reverse(ListNode head, ListNode newTail) {
        // recursive
        if(head == null)    return newTail;
        ListNode next = head.next;
        head.next = newTail;
        return reverse(next, head);
    }
    
    public ListNode findEnd(ListNode head) {
        while(head.next != null)    head = head.next;
        return head;
    }
}