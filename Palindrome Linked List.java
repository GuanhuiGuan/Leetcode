class Solution {
	// public class ListNode {
	// 	int val;
	// 	ListNode next;
	// 	ListNode(int x) { val = x; }
	// }
	
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        ListNode tail = reverse(getTail(head));
        while(tail != null) {
            if(tail.val != head.val) return false;
            tail = tail.next;
            head = head.next;
        }
        return true;
    }
    
    public ListNode getTail(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // even: half; odd: omit center node
        return fast == null? slow: slow.next;
    }
    
    public ListNode reverse(ListNode node) {
        return iterative(node);
//        return recursive(node, null);
    }
    
    public ListNode iterative(ListNode node) {
        ListNode dr = new ListNode(0);
        
        while(node != null) {
            ListNode next = node.next;
            node.next = dr.next;
            dr.next = node;
            node = next;
        }
        return dr.next;
    }
    
    public ListNode recursive(ListNode node, ListNode tail) {
        if(node == null) return tail;
        ListNode next = node.next;
        node.next = tail;
        return recursive(next, node);
    }
    
}
