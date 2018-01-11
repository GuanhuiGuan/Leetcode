/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while(head != null) {
            s.push(head.val);
            head = head.next;
        }
        
        int last = s.pop() + 1;
        int forward = last/10;
        ListNode node = new ListNode(last%10);
        while(!s.isEmpty()) {
            int sum = forward + s.pop();
            ListNode root = new ListNode(sum%10);
            forward = sum/10;
            root.next = node;
            node = root;
        }
        if(forward != 0){
            ListNode root = new ListNode(forward);
            root.next = node;
            node = root;
        }    
        return node;
    }
}