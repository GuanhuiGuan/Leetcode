class Solution {
    public int calculate(String s) {
        // stack to store previous values and operands
        // 2 lvls, lvl1 -> (+, -), lvl2 -> (*, /), marked by op = {1, -1}
        Stack<Integer> stack = new Stack<>();
        int prev1 = 0, prev2 = 1, op1 = 1, op2 = 1;
        
        // digit, +/-, *//, ()
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10*num + s.charAt(i++) - '0';
                }
                // to offset the i so that nothing is omitted
                i--;
                // store in lvl2
                prev2 = (op2==1? prev2*num: prev2/num);
            }
            else if(c == '+' || c == '-') {
                // save the current lvl2
                prev1 += op1*prev2;
                op1 = ((c=='+')? 1: -1);
                // reset lvl2
                prev2 = 1;
                op2 = 1;
            }
            
            else if(c == '*' || c == '/') {
                op2 = ((c=='*')? 1: -1);
            }
            
            else if(c == '(') {
                stack.push(prev1);
                stack.push(prev2);
                stack.push(op1);
                stack.push(op2);
                prev1 = 0; op1 = 1;
                prev2 = 1; op2 = 1;
            }
            
            else if(c == ')') {
                // save the current value inside the parentheses
                int cur = prev1 + op1*prev2;
                op2 = stack.pop();
                op1 = stack.pop();
                prev2 = stack.pop();
                prev1 = stack.pop();
                
                prev2 = ((op2==1)? prev2*cur: prev2/cur);
            }
        }
        return prev1 + op1*prev2;
    }
}