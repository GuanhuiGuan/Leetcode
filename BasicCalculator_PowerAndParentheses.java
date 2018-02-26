class Solution {
    public int calculate(String s) {
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('^', 3);
        
        return cal(s, priority);
    }
    
    public int cal(String s, Map<Character, Integer> priority) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        char[] cs = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            // digit
            if(Character.isDigit(cs[i])) {
                int num = 0;
                while(i < cs.length && Character.isDigit(cs[i])) {
                    num = 10*num + cs[i++]-'0';
                }
                i--;
                operands.push(num);
            }
            // left parenthesis
            else if(cs[i] == '(') {
                int j = i+1, count = 1;
                while(j < cs.length) {
                    if(cs[j] == '(')    count++;
                    if(cs[j] == ')')    count--;
                    if(count == 0)  break;
                    j++;
                }
                int paren = cal(s.substring(i+1, j), priority);
                operands.push(paren);
                // skip to the right parenthesis
                i = j;
            }
            // operators
            else if(priority.containsKey(cs[i])) {
                while(!operators.isEmpty() && priority.get(cs[i]) <= priority.get(operators.peek())) {
                    int y = operands.pop();
                    int x = operands.pop();
                    char c = operators.pop();
                    int temp = merge(x, y, c);
                    operands.push(temp);
                }
                operators.push(cs[i]);
            }
        }
        
        // merge the rest
        while(!operators.isEmpty()) {
            int y = operands.pop();
            int x = operands.pop();
            char c = operators.pop();
            int temp = merge(x, y, c);
            operands.push(temp);
        }
        return operands.pop();
    }
    
    public int merge(int x, int y, char c) {
        if(c == '+')    return x + y;
        else if(c == '-')    return x - y;
        else if(c == '*')    return x * y;
        else if(c == '/')    return x / y;
        else    return (int)Math.pow(x, y);
    }
    
}