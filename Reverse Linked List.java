/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // return iterative(head);
        return recursive(head);
    }
    
    public ListNode iterative(ListNode head) {
        ListNode dr = new ListNode(0);
        ListNode cur = head;
        
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = dr.next;
            dr.next = cur;
            cur = next;
        }
        return dr.next;
    }
    
    public ListNode recursive(ListNode head) {
        return recurHelper(head, null);
    }
    
    public ListNode recurHelper(ListNode ori, ListNode tail) {
        if(ori == null) return tail;
        ListNode nextOri = ori.next;
        ori.next = tail;
        return recurHelper(nextOri, ori);
    }
}