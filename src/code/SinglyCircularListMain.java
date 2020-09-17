package code;

class SinglyCircularList {
	static class Node {
		private int data;
		private Node next;
		
		public Node() {
			data = 0;
			next = null;
		}
		public Node(int val) {
			data = val;
			next = null;
		}
	}

	private Node head;
	private int count;
	public SinglyCircularList() {
		head = null;
		count = 0;
	}
	
	public void display() {
		System.out.print("List: ");
		if(head != null) {
			Node trav = head;
			do {
				System.out.print(trav.data + ", ");
				trav = trav.next;
			}while(trav != head);
		}
		System.out.println();
	}
	public void addLast(int val) {
		// create new node
		Node newNode = new Node(val);
		// spl: list is empty
		if(head == null) {
			// add node at the start of list
			head = newNode;
			// make it circular
			newNode.next = head;
		} else {
			// traverse till last node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			// newnode's next to head
			newNode.next = head;
			// last node's next to new node
			trav.next = newNode;
		}
		count++;
	}
	public void addFirst(int val) {
		// create new node
		Node newNode = new Node(val);
		// spl: list is empty
		if(head == null) {
			// add node at the start of list
			head = newNode;
			// make it circular
			newNode.next = head;
		} else {
			// traverse till last node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			// newnode's next to head
			newNode.next = head;
			// last node's next to new node
			trav.next = newNode;
		}
		// head should point to the new node (add FIRST)
		head = newNode;
		count++;
	}
	public void addAtPos(int val, int pos) {
		// spl 4. invalid pos (< 1)
		if(pos < 1 || pos > count+1)
			throw new RuntimeException("Invalid position " + pos);
		// spl 1. if list is empty OR spl 2. add at pos = 1
		if(head == null || pos == 1)
			addFirst(val);
		else {
			// create a new node
			Node newNode = new Node(val);
			// traverse till pos - 1
			Node trav = head;
			for(int i=1; i<pos-1; i++)
				trav = trav.next;
			// add node at that pos
			newNode.next = trav.next;
			trav.next = newNode;
			count++;
		}
		
	}
	public void delFirst() {
		// spl1: list is empty
		if(head == null)
			throw new RuntimeException("List is empty.");
		// spl2: list contains only one element
		if(head == head.next)
			head = null;
		else {
			// traverse till last node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			// take head to the next node (2nd)
			head = head.next;
			// last nodd's next to the new head
			trav.next = head;
		}
		count--;
	}
	public void delAll() {
		while(head != null)
			delFirst();
	}
	public void delAtPos(int pos) {
		// homework: similar to singly linear linked list
	}
}

public class SinglyCircularListMain {
	public static void main(String[] args) {
		SinglyCircularList obj = new SinglyCircularList();
		obj.addLast(11);
		obj.addLast(22);
		obj.addLast(33);
		obj.addFirst(44);
		obj.display();
		obj.addAtPos(55, 4);
		obj.display();
	}
}
