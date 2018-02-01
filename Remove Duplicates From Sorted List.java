/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dr = new ListNode(0), pre = dr, cur = head;
        dr.next = head;
        
        while(cur != null) {
            while(pre != dr && cur != null && cur.val == pre.val)  cur = cur.next;
            pre.next = cur;
            pre = pre.next;
            if(cur != null) cur = cur.next;
        }
        return dr.next;
    }
}