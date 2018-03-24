/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // recursion
    public ListNode reverseList(ListNode head) {
        // use helper with two input nodes, one for attach at end, one for unprocessed part
        return helper(head, null);
    }
    
    public ListNode helper(ListNode unPro, ListNode tail) {
        // unPro: head of unprocessed; tail: what to attach at the tail
        if(unPro == null) return tail;
        ListNode nextUnPro = unPro.next;
        unPro.next = tail;
        ListNode newHead = helper(nextUnPro, unPro);
        return newHead;
    }
    
    
    // iterative
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        // cur cannot be root
        ListNode root = new ListNode(0), cur = head, next = head.next;
        root.next = head;
        while(next != null) {
            cur.next = next.next;
            next.next = root.next;
            root.next = next;
            next = cur.next;
        }
        return root.next;
    }
}