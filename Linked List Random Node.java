/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int rsv;
    Random r = new Random();
    ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        // O(n) sweep through all, switch with element i with prob=1/i
        // prob of survival = 1/(i-1) * (i-1)/i [prob of i==rsv * prob of not choosing new element]
        ListNode node = head;
        rsv = node.val;
        node = node.next;
        int i = 1;
        while(node != null) {
            int next = r.nextInt(i+1);
            if(next == i)   rsv = node.val;
            node = node.next;
            i++;
        }
        return rsv;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */