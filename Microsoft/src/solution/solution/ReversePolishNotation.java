package solution;

import java.util.Stack;

public class ReversePolishNotation {
	
	static boolean isOperator(String op)
	{
		if(op == "*" || op == "/" || op == "+" || op == "-") {
			return true;
		}else {
			return false;
		}
	}
	
	public static int rvpn(String[] tokens) {
		
		Stack<String>stack = new Stack<>();
		for(int i = 0; i< tokens.length;i++) {
			if(isOperator(tokens[i])) {
				int op2 = Integer.parseInt(stack.pop());
				int op1 = Integer.parseInt(stack.pop());
				int ans = 0;
				if(tokens[i] == "*") {
					ans = op1 * op2;
				}else if(tokens[i] == "/") {
					ans = op1 / op2;
				}else if(tokens[i] == "+") {
					ans = op1 + op2;
				}else if(tokens[i] == "-") {
					ans = op1 - op2;
				}
				stack.push(String.valueOf(ans));
			}else {
				stack.push(tokens[i]);
			}
		}
		return Integer.parseInt(stack.peek());
	}
	public static void main(String[]args) {
		String tokens[] = {"10", "6", "9",  "3", "+", "-11", "*",
                "/",  "*", "17", "+", "5", "+" };
		System.out.println(rvpn(tokens));
		
	}

}
