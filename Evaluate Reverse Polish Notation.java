class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(token.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                a = a + b;
                stack.push(a);
            }
            else if(token.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                a = b - a;
                stack.push(a);
            }
            else if(token.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                a = a*b;
                stack.push(a);
            }
            else if(token.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                a = b/a;
                stack.push(a);
            }
            // otherwise is number
            else{
                int d = Integer.parseInt(token);
                stack.push(d);
            }
        }
        return stack.pop();
    }
}