/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dr1 = new ListNode(0), dr2 = new ListNode(0);
        ListNode t1 = dr1, t2 = dr2;
        
        // iterate original list with head, link elements to two lists
        while(head != null) {
            if(head.val < x) {
                t1.next = head;
                t1 = t1.next;
            }
            else {
                t2.next = head;
                t2 = t2.next;
            }
            head = head.next;
        }
        // clear the tails and reconnect both parts
        t2.next = null;
        t1.next = dr2.next;
    
        return dr1.next;
    }
}