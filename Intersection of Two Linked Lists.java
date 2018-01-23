/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // iterate ptrs on both ends
        ListNode na = headA, nb = headB;
        while(na != nb) {
            if(na == null)  na = headB;
            else    na = na.next;
            if(nb == null)  nb = headA;
            else    nb = nb.next;
        }
        return na;
        
//         // find dif in lengths and adjust
//         int a = 0, b = 0;
//         ListNode na = headA, nb = headB;
//         while(na != null) {
//             na = na.next;
//             a++;
//         }
//         while(nb != null) {
//             nb = nb.next;
//             b++;
//         }
        
//         na = headA;
//         nb = headB;
//         if(a > b) {
//             int dif = a-b;
//             while(dif-- > 0)    na = na.next;
//         }
//         else {
//             int dif = b-a;
//             while(dif-- > 0)    nb = nb.next;
//         }
//         while(na != null && nb != null) {
//             if(na == nb)    return na;
//             na = na.next;
//             nb = nb.next;
//         }
//         return null;
    }
}