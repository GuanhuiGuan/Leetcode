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
        // 2 ptrs
        ListNode dr = new ListNode(0), pre = dr, cur = head;
        dr.next = head;
        
        while(cur != null) {
            // let cur skip to the end of a subarray of same element
            while(cur.next != null && cur.val == cur.next.val)  cur = cur.next;
            
            // if cur is 1 step behind pre, then unique element
            if(pre.next == cur) pre = pre.next;
            // duplicate, skip all, and not certain of this element yet
            else    pre.next = cur.next;
            cur = cur.next;
        }
        return dr.next;
        
        // // construct new list
        // Set<Integer> set = new HashSet<>();
        // while(head != null) {
        //     // if exist, remove
        //     if(!set.add(head.val))  set.remove(head.val);
        //     head = head.next;
        // }
        // ListNode dr = new ListNode(0), node = dr;
        // for(int num: set) {
        //     node.next = new ListNode(num);
        //     node = node.next;
        // }
        // return dr.next;
    }
}