/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)    return head;
        ListNode root = head, tail = head;
        int cnt = 1;
        while(tail.next != null){
            cnt++;
            tail = tail.next;
        }
        // cycle the list
        tail.next = head;
        // find the index of rotated tail in original list, index n-1-k
        k %= cnt;
        if(k != 0) {
            for(int i = 0; i < cnt-k; i++)  tail = tail.next;
        }
        root = tail.next;
        tail.next = null;
        return root;
    }
}