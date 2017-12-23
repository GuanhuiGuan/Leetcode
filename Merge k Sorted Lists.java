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
        if(lists.length == 0)   return null;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                if(o1.val < o2.val) return -1;
                if(o1.val == o2.val)    return 0;
                else    return 1;
            }
        });
        
        for(ListNode list: lists){
            if(list != null)    heap.add(list);
        }
        
        ListNode dr = new ListNode(0);
        ListNode move = dr;
        while(!heap.isEmpty()){
            ListNode newList = heap.poll();
            move.next = newList;
            move = move.next;
            newList = newList.next;
            if(newList != null) heap.add(newList);
        }
        
        return dr.next;
    }
}