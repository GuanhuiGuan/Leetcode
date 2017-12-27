/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // link node.next = copy for each node, assign random to copys, and seperate two lists
        // 1. link node.next to copy for each node
        RandomListNode node = head, nextNode, copy;
        while(node != null){
            nextNode = node.next;
            copy = new RandomListNode(node.label);
            node.next = copy;
            copy.next = nextNode;
            
            node = nextNode;
        }
        
        // 2. assign random to copys
        node = head;
        while(node != null){
            if(node.random != null){
                // every node must have next(copy), link copy to copy
                node.next.random = node.random.next;
            }
            // move on regardless of having random or not
            node = node.next.next;
        }
        
        // 3. seperate lists
        RandomListNode cDR = new RandomListNode(0);
        RandomListNode copyPre = cDR;
        node = head;
        while(node != null){
            nextNode = node.next.next;
            copy = node.next;
            copyPre.next = copy;
            copyPre = copy;
            node.next = nextNode;
            
            node = nextNode;
        }
        
        return cDR.next;
    }
}