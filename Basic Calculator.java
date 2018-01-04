class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] cs = s.toCharArray();
        int num = 0;
        int sign = 1;
        int re = 0;
        
        for(int i = 0; i < cs.length; i++){
            if(Character.isDigit(cs[i])){
                num = 10*num + cs[i]-'0';
            }
            if(cs[i] == '+'){
                re += sign*num;
                sign = 1;
                num = 0;
            }
            if(cs[i] == '-'){
                re += sign*num;
                sign = -1;
                num = 0;
            }
            if(cs[i] == '('){
                // save previous and reset
                stack.push(re);
                stack.push(sign);
                re = 0;
                num = 0;
                sign = 1;
            }
            if(cs[i] == ')'){
                // mul sign and add before, reset
                re += sign*num;
                re *= stack.pop();
                re += stack.pop();
                num = 0;
                sign = 1;
            }
        }
        // if one character or for last character
        if(num != 0){
            re += sign*num;
        }
        return re;
    }
}