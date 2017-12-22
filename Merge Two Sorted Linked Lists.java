/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dr = new ListNode(0);
        ListNode root = dr;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                dr.next = new ListNode(l1.val);
                dr = dr.next;
                l1 = l1.next;
            }
            else{
                dr.next = new ListNode(l2.val);
                dr = dr.next;
                l2 = l2.next;
            }
        }
        if(l1 != null)  dr.next = l1;
        if(l2 != null)  dr.next = l2;
        return root.next;
    }
}