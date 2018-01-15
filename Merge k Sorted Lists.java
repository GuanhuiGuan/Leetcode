/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0)  return null;
        if(n == 1)  return lists[0];
        ListNode re = new ListNode(0), node = re;
        // stores single nodes, sorted
        Queue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        for(ListNode l: lists) {
            if(l != null)   heap.offer(l);
        }
        while(!heap.isEmpty()) {
            ListNode cur = heap.poll();
            node.next = cur;
            if(cur.next != null)    heap.offer(cur.next);
            node = node.next;
        }
        return re.next;
    }
}