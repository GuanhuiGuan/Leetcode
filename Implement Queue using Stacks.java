class MyQueue {
    Stack<Integer> input, output;

    // modify peek and push, O(1) amortized
    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(output.isEmpty()) {
            while(!input.isEmpty()) output.push(input.pop());
        }
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
    
    // modify push only version
//     Stack<Integer> stack0, stack1;

//     /** Initialize your data structure here. */
//     public MyQueue() {
//         stack0 = new Stack<>();
//         stack1 = new Stack<>();
//     }
    
//     /** Push element x to the back of queue. */
//     public void push(int x) {
//         while(!stack0.isEmpty())    stack1.push(stack0.pop());
//         stack0.push(x);
//         while(!stack1.isEmpty())    stack0.push(stack1.pop());
//     }
    
//     /** Removes the element from in front of queue and returns that element. */
//     public int pop() {
//         return stack0.pop();
//     }
    
//     /** Get the front element. */
//     public int peek() {
//         return stack0.peek();
//     }
    
//     /** Returns whether the queue is empty. */
//     public boolean empty() {
//         return stack0.isEmpty();
//     }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */