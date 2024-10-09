package org.code;

import java.util.Stack;

public class ExpressionMain {
	public static int pri(char op) {
		switch (op) {
			case '$': return 10;
			case '*': return 7;
			case '/': return 7;
			case '%': return 7;
			case '+': return 4;
			case '-': return 4;
		}
		return 0;
	}
	public static String infixToPostfix(String infix) {
		java.util.Stack<Character> s = new Stack<Character>();
		String postfix = "";
		//1. access symbols from infix one by one (left to right)
		for(int i=0; i<infix.length(); i++) {
			char sym = infix.charAt(i);
			//2. if symbol is operand, append it to postfix.
			if(Character.isDigit(sym))
				postfix = postfix + sym;
			//5. if opening ( is found, push it on stack
			else if(sym == '(')
				s.push(sym);
			//6. if closing ) is found, pop all operators from stack one by one and append to postfix, until opening ( is found on stack.
			else if(sym == ')') {
				while(s.peek().charValue() != '(')
					postfix = postfix + s.pop();
				s.pop(); // pop and discard opening ( as well. 
			}
			else { //3. if symbol is operator, push it on stack.
				// * if priority of topmost operator >= priority of current operator, 
				// then pop it and append to posfix.
				while(!s.isEmpty() && pri(s.peek()) >= pri(sym))
					postfix = postfix + s.pop();
				s.push(sym);
			}
		}
		//4. if all symbols from infix are over, 
			// then pop all operators from stack one by one and append to postfix.
		while(!s.isEmpty())
			postfix = postfix + s.pop();
		return postfix;
	}

	public static String infixToPrefix(String infix) {
		java.util.Stack<Character> s = new Stack<Character>();
		String prefix = "";
		//1. access symbols from infix one by one (right to left)
		for(int i=infix.length()-1; i>=0; i--) {
			char sym = infix.charAt(i);
			//2. if symbol is operand, append it to prefix.
			if(Character.isDigit(sym))
				prefix = prefix + sym;
			//5. if closing ) is found, push it on stack
			else if(sym == ')')
				s.push(sym);
			//6. if opening ( is found, pop all operators from stack one by one and append to prefix, until closing ) is found on stack.
			else if(sym == '(') {
				while(s.peek().charValue() != ')')
					prefix = prefix + s.pop();
				s.pop(); // pop and discard closing ) as well. 
			}
			else { //3. if symbol is operator, push it on stack.
				// * if priority of topmost operator > priority of current operator, 
				// then pop it and append to prefix.
				while(!s.isEmpty() && pri(s.peek()) > pri(sym))
					prefix = prefix + s.pop();
				s.push(sym);
			}
		}
		//4. if all symbols from infix are over, 
			// then pop all operators from stack one by one and append to prefix.
		while(!s.isEmpty())
			prefix = prefix + s.pop();
		//7. reverse the prefix to get the result
		return new StringBuilder(prefix).reverse().toString();
	}

	public static void main(String[] args) {
		//String infix = "1+2*3";
		String infix = "5+9-4*(8-6/2)+1$(7-3)";
		String postfix = infixToPostfix(infix);
		System.out.println("Postfix: " + postfix);
		String prefix = infixToPrefix(infix);
		System.out.println("Prefix: " + prefix);
	}
}

