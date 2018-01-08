/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        // splitting: find quotient and remainder
        ListNode[] splits = new ListNode[k];
        int n = 0;
        ListNode tail = root, prev = root;
        while(tail != null) {
            n++;
            tail = tail.next;
        }
        int qte = n/k, rmd = n%k;
        
        tail = root;
        for(int i = 0; i < k && tail != null; i++, rmd--) {
            splits[i] = tail;
            prev = tail;
            for(int j = 0; j < qte + (rmd > 0? 1: 0); j++) {
                prev = tail;
                tail = tail.next;
            }
            prev.next = null;
        }
        return splits;
    }
}