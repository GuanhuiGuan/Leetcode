class MaxStack {
    // double stack
    Stack<Integer> stack;
    // stores the max for every insertion
    Stack<Integer> stackMax;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        stackMax = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        
        int curMax = Integer.MIN_VALUE;
        if(!stackMax.isEmpty()){
            curMax = stackMax.peek();
        }
        curMax = Math.max(curMax, x);
        stackMax.push(curMax);
    }
    
    public int pop() {
        stackMax.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return stackMax.peek();
    }
    
    public int popMax() {
        int curMax = stackMax.peek();
        Stack<Integer> buf = new Stack<>();
        
        // find the max in stack, update both stack simultaneously
        while(stack.peek() != curMax){
            buf.push(stack.pop());
            stackMax.pop();
        }
        // found it and remove it
        stack.pop();
        stackMax.pop();
        // restore
        while(!buf.isEmpty()){
            push(buf.pop());
        }
        return curMax;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */


//double linkedlist and arraylist
// class MaxStack {
//     DLNode head = new DLNode(0), tail = new DLNode(0);
//     // maxheap
//     List<Integer> list = new ArrayList<>();

//     /** initialize your data structure here. */
//     public MaxStack() {
//         head.next = tail;
//         tail.pre = head;
//     }
    
//     public void push(int x) {
//         list.add(x);
//         DLNode node = new DLNode(x);
//         node.pre = head;
//         node.next = head.next;
//         head.next.pre = node;
//         head.next = node;
//     }
    
//     public int pop() {
//         int x = head.next.val;
//         head.next.next.pre = head;
//         head.next = head.next.next;
        
//         for(int i = 0; i < list.size(); i++){
//             if(list.get(i) == x){
//                 list.remove(i);
//                 break;  
//             }
//         }
//         return x;
//     }
    
//     public int top() {
//         return head.next.val;
//     }
    
//     public int peekMax() {
//         int m = Integer.MIN_VALUE;
//         for(int i = 0; i < list.size(); i++){
//             if(m < list.get(i)){
//                 m = list.get(i);
//             }
//         }
//         return m;
//     }
    
//     public int popMax() {
//         int m = peekMax();
//         for(int i = 0; i < list.size(); i++){
//             if(list.get(i) == m){
//                 list.remove(i);
//                 break;  
//             }
//         }
//         DLNode node = head.next;
//         while(node.val != m){
//             node = node.next;
//         }
//         node.pre.next = node.next;
//         node.next.pre = node.pre;
//         return m;
//     }
    
//     class DLNode {
//         int val;
//         DLNode pre = null, next = null;
//         public DLNode(int v) {
//             val = v;
//         }
//     }
// }

// /**
//  * Your MaxStack object will be instantiated and called as such:
//  * MaxStack obj = new MaxStack();
//  * obj.push(x);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.top();
//  * int param_4 = obj.peekMax();
//  * int param_5 = obj.popMax();
//  */