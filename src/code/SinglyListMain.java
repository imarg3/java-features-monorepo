package code;


class SinglyList{
	static class Node{
		private int data;
		private Node next;
		
		public Node() {
			this.data = 0;
			this.next = null;
		}
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	private Node head;
	
	public SinglyList() {
		head = null;
	} 
	
	// time complexity - O(1)
	public void addFirst(int value) {
		Node newNode = new Node(value);
		// First make, then break
		newNode.next = head;
		head = newNode;
	}
	
	// time complexity - O(n)
	public void addLast(int value) {
		Node newNode = new Node(value);
		// special case: if list is empty
		if(head == null)
			head = newNode; // newNode itself is first node of list
		else { // general case: if list already have few nodes
			// traverse till last node
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			// add address of newNode into last node's next
			trav.next = newNode;
		}
	}
	
	// time complexity - O(n)
	public void display() {
		System.out.print("List: ");
		Node trav = head;
		while(trav != null) {
			System.out.print(trav.data + ", ");
			trav = trav.next;
		}
		System.out.println();
	}
}

public class SinglyListMain {
	public static void main(String[] args) {
		SinglyList list1 = new SinglyList();
		list1.addLast(10);
		list1.addLast(20);
		list1.addLast(30);
		list1.addFirst(40);
		list1.display();
	}
}
