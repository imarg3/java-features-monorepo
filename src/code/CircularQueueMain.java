package code;

class CircularQueue {
	private int[] arr;
	private int front, rear;
	
	public CircularQueue(int size) {
		arr = new int[size];
		front = -1;
		rear = -1;
	}
	
	public void push(int val) {
		rear = (rear+1) % arr.length;
		arr[rear] = val;
	}
	
	public void pop() {
		front = (front+1) % arr.length;
		if(front == rear) {
			front = -1;
			rear = -1;
		}
	}
	
	public int peek() {
		int index = (front+1) % arr.length;
		return arr[index];
	}
	
	public boolean isEmpty() {
		return (front==rear && front==-1);
	}
	
	public boolean isFull() {
		return (front==-1 && rear==arr.length-1) && 
				(front==rear && front!=-1);
	}
}

public class CircularQueueMain {
	public static void main(String[] args) {
		CircularQueue q = new CircularQueue(6);
		if(!q.isFull())
			q.push(11);
		if(!q.isFull())
			q.push(22);
		if(!q.isFull())
			q.push(33);
		if(!q.isFull())
			q.push(44);
		
		System.out.println("Element at front : " + q.peek() + "\n");
		
		while(!q.isEmpty()) {
			System.out.println("Popping: " + q.peek());
			q.pop();
		}
	}
}

