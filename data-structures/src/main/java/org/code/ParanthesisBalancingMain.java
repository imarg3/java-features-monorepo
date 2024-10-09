package org.code;
import java.util.Stack;

public class ParanthesisBalancingMain {
	public static boolean isParenthesisBalanced(String expr) {
		Stack<Character> s = new Stack<Character>();
		String open = "([{<";
		String close = ")]}>";
		int index;
		for (int i = 0; i < expr.length(); i++) {
			char sym = expr.charAt(i);
			index = open.indexOf(sym);
			if(index != -1) // if opening parenthesis
				s.push(sym);
			else {
				index = close.indexOf(sym);
				if(index != -1) { // if closing parenthesis
					if(s.isEmpty()) // not balanced -- extra closing parenthesis
						return false;
					char top = s.pop();
					if(open.indexOf(top) != index) // not balanced -- opening != closing
						return false;
				}
				else {
					// ... other characters -- alphabets or digits or operators
					// continue
				}
			}
		}
		if(!s.isEmpty()) // not balanced -- extra opening parenthesis
			return false;
		return true; // balanced
	}
	
	public static void main(String[] args) {
		String expr = "5+([9-4]*(8-{6/2}))";
		if(isParenthesisBalanced(expr)) 
			System.out.println("Parenthesis are balanced.");
		else 
			System.out.println("Parenthesis are not balanced.");
	}
}
