/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // // Iterative
    // public ListNode reverseList(ListNode head) {
    //     ListNode front = head, back = null;
    //     while(front != null) {
    //         // save the advanced node ahead of front, fix front's next
    //         ListNode adv = front.next;
    //         front.next = back;
    //         // both nodes move forward
    //         back = front;
    //         front = adv;
    //     }
    //     // front is now null
    //     return back;
    // }
    
//     // Recursive 2 nodes
//     public ListNode reverseList(ListNode head) {
//         return iterative(head, null);
//     }
    
//     public ListNode iterative(ListNode front, ListNode back) {
//         if(front == null)   return back;
//         ListNode adv = front.next;
//         front.next = back;
//         return iterative(adv, front);
//     }
    
    // Recursive 1 node
    public ListNode reverseList(ListNode head) {
        // one node, head is back and head.next is front, get node in the future first
        if(head == null || head.next == null)   return head;
        ListNode newHead = reverseList(head.next);
        // reverse current 2 nodes
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}