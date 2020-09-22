package code;

import java.util.Scanner;

class Stack{
	private int[] arr;
	private int top;
	
	public Stack(int size) {
		arr = new int[size];
		top = -1;
	}
	
	public void push(int value) {
		top++;
		arr[top] = value;
	}
	
	public void pop() {
		top--;
	}
	
	public int peek() {
		return arr[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == arr.length - 1; 
	}
}

public class StackMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice, val;
		Stack s = new Stack(5);
		do {
			System.out.print("\n\n1. push\n2. pop\n3. peek\nenter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: // push
				if(s.isFull())
					System.out.println("Stack is full.");
				else {
					System.out.print("enter element to push: ");
					val = sc.nextInt();
					s.push(val);
				}
				break;
			case 2: // pop
				if(s.isEmpty())
					System.out.println("Stack is empty.");
				else {
					val = s.peek();
					s.pop();
					System.out.println("popped element: " + val);
				}
				break;
			case 3: // peek
				if(s.isEmpty())
					System.out.println("Stack is empty.");
				else {
					val = s.peek();
					System.out.println("topmost element: " + val);
				}
				break;
			}
		}while(choice != 0);
		sc.close();
	}
}
