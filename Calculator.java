package calculator;
import java.util.*;

public class Calculator {
	public int cal(String s) {
		char[] cs = s.toCharArray();
		Stack<Integer> stack = new Stack<>();
		
		int i = 0;
		int prev1 = 0, op1 = 1, prev2 = 1, op2 = 1;
		while(i < cs.length) {
			// new num
			if(Character.isDigit(cs[i])) {
				int num = 0;
				while(i < cs.length && Character.isDigit(cs[i])) {
					num = 10*num + cs[i++]-'0';
				}
				i--; // avoid skipping
				
				if(op2 == 1)	prev2 *= num;
				else if(op2 == 2)	prev2 /= num;
				else	prev2 = (int)(Math.pow(prev2, num));
				
			}
			// lvl 1 operator
			else if(cs[i] == '+' || cs[i] == '-') {
				prev1 += op1*prev2;
				op1 = cs[i]=='+'? 1: -1;
				op2 = 1;
				prev2 = 1;
			}
			// lvl 2 operator
			else if(cs[i] == '*' || cs[i] == '/' || cs[i] == '^') {
				if(cs[i] == '*')	op2 = 1;
				else if(cs[i] == '/')	op2 = 2;
				else	op2 = 3;
				
			}
			// left parenthesis, cache and reset
			else if(cs[i] == '(') {
				stack.push(prev1);
				stack.push(prev2);
				stack.push(op1);
				stack.push(op2);
				prev1 = 0;
				prev2 = 1;
				op1 = 1;
				op2 = 1;
			}
			// right parenthesis, merge
			else if(cs[i] == ')') {
				int num = prev1 + op1*prev2;
				op2 = stack.pop();
				op1 = stack.pop();
				prev2 = stack.pop();
				prev1 = stack.pop();
				
				if(op2 == 1)	prev2 *= num;
				else if(op2 == 2)	prev2 /= num;
				else	prev2 = (int)(Math.pow(prev2, num));
				
			}
			i++;
		}
		return prev1 + op1*prev2;
	}
}
