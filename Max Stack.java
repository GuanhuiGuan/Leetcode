class MaxStack {
    Stack<Integer> stack = new Stack<>(), max_stack = new Stack<>();

    /** initialize your data structure here. */
    public MaxStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(max_stack.isEmpty() || x > max_stack.peek())    max_stack.push(x);
        else    max_stack.push(max_stack.peek());
    }
    
    public int pop() {
        max_stack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return max_stack.peek();
    }
    
    public int popMax() {
        // keep two stacks synchronous
        Stack<Integer> temp = new Stack<>();
        int tempMax = max_stack.peek();
        while(stack.peek() != tempMax) {
            temp.push(stack.pop());
            max_stack.pop();
        }
        stack.pop();
        max_stack.pop();
        while(!temp.isEmpty()){
            push(temp.pop());
        }
        return tempMax;
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