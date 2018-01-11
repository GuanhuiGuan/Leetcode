/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }   
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        // 1 pass to reverse the outcome
        ListNode node = new ListNode(0);
        int forward = 0;
        Stack<Integer> s = new Stack<>();
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int sum = forward;
            if(!s1.isEmpty())   sum += s1.pop();
            if(!s2.isEmpty())   sum += s2.pop();
            node.val = (sum%10);
            forward = sum/10;
            ListNode root = new ListNode(0);
            root.next = node;
            node = root;
        }
        if(forward != 0)    node.val = (forward);
        
        return node.val == 0? node.next: node;
    }
}