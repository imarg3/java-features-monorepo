package code;

import java.util.Scanner;

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
	
	// time complexity - O(n) or O(pos)
	public void addAtPos(int value, int pos) {
		// spl 4. invalid pos (< 1)
		if(pos < 1)
			throw new RuntimeException("Invalid position " + pos);
		// spl 1. if list is empty OR spl 2. add at pos = 1
		if(head == null || pos == 1)
			addFirst(value);
		else {
			// create a new node
			Node newNode = new Node(value);
			// traverse till pos - 1
			Node trav = head;
			for(int i=1; i<pos-1; i++) {
				trav = trav.next;
				// spl 3. if pos to add is beyond length of list, throw error
				if(trav == null)
					throw new RuntimeException("Invalid position " + pos);
			}
			// add node at that pos
			newNode.next = trav.next;
			trav.next = newNode;
		}
	}
	
	// time complexity - O(1)
	public void delFirst() {
		if(head == null)
			throw new RuntimeException("List is empty.");
		head = head.next;
	}
	
	// time complexity - O(n) or O(pos)
	public void delAtPos(int pos) {
		// spl 3: if pos < 1, throw exception
		if(pos < 1)
			throw new RuntimeException("Invalid position " + pos);
		// spl 1: list is empty & 2: pos == 1
		if(head == null || pos == 1)
			delFirst();
		else {
			Node trav = head;
			for(int i=1; i<pos-1; i++) {
				trav = trav.next;
				// spl 4: if pos > length, throw exception
				if(trav == null)
					throw new RuntimeException("Invalid position " + pos);
				
			}
			Node temp = trav.next;
			// spl 5: pos == length, if temp is null, throw exception
			if(temp == null)
				throw new RuntimeException("Invalid position " + pos);
			trav.next = temp.next;
		}
	}
	
	// time complexity - O(n)
	void deleteAll() {
		while(head != null)
			delFirst();
		//head = null;
	}
	
	// time complexity - O(n)
	void delLast() {
		// spl1: list is empty, spl2: list have only one node.
		if(head == null || head.next == null)
			delFirst();
			
		Node temp = null, trav = head;
		while(trav.next != null) {
			temp = trav;
			trav = trav.next;
		}
		temp.next = null;
	}
}

public class SinglyListMain {
	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
		  SinglyList obj = new SinglyList(); 
		  int choice, pos; 
		  int val = 0;
		  
		  do { 
			  System.out.print("\n\n0. Exit\n1. Add First\n2. Add Last\n3. Add At Pos\n4. Display\n5. Del First\n6. Del Last\n7. Del At Pos\n8. Del All\nEnter choice: "); 
			  choice = sc.nextInt(); 
			  switch (choice) { 
			  	case 1: 
			  			// Add First
			  			System.out.print("Enter element: "); val = sc.nextInt(); obj.addFirst(val);
			  			break; 
			  	case 2: 
			  		// Add Last 
			  		System.out.print("Enter element: "); 
			  		val = sc.nextInt(); obj.addLast(val); break; 
			  	case 3: // Add At Pos
			  		System.out.print("Enter element: "); 
			  		val = sc.nextInt();
			  		System.out.print("Enter position (1-based): "); 
			  		pos = sc.nextInt();
			  		obj.addAtPos(val, pos); 
			  		break; 
			  	case 4: 
			  		// Display 
			  		obj.display();
			  		break; 
			  	case 5: 
			  		// Del First 
			  		obj.delFirst(); 
			  		break; 
			  	case 6: 
			  		// Del Last 
			  		obj.delLast();
			  		break; 
			  	case 7: 
			  		// Del At Pos 
			  		System.out.print("Enter position (1-based): ");
			  		pos = sc.nextInt(); 
			  		obj.delAtPos(pos); 
			  		break; 
			  	case 8: // Del All
			  		obj.deleteAll(); 
			  		break; 
			  } 
		}while(choice != 0); 
		sc.close();
		 
		/*
		SinglyList list1 = new SinglyList();
		list1.addLast(11);
		list1.addLast(22);
		list1.addLast(33);
		list1.addLast(44);
		list1.addAtPos(55, 5);		
		list1.display();
		list1.delFirst();
		list1.display();
		list1.deleteAll();
		list1.display();
		*/
	}
}
