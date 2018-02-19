class Solution {
    public String parseTernary(String expression) {
        // sweep backwards with stack, store every char
        if(expression == null || expression.length() == 0)  return "";
        Stack<Character> stack = new Stack<>();
        
        for(int i = expression.length()-1; i >= 0; i--) {
            char c = expression.charAt(i);
            // if we have ? and we meet the condition term
            if(!stack.isEmpty() && stack.peek() == '?') {
                // pop ?
                stack.pop();
                char t1 = stack.pop();
                // pop :
                stack.pop();
                char t2 = stack.pop();
                
                // choose one
                if(c == 'T')    stack.push(t1);
                else    stack.push(t2);
            }
            // else, store in stack
            else    stack.push(c);
        }
        return String.valueOf(stack.peek());
    }
}