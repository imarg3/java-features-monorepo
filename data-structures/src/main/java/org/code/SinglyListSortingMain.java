package org.code;

class SinglyListSort {
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
	
	public SinglyListSort() {
		head = null;
	}
	
	// time complexity - O(n)
	public void addLast(int val) {
		Node newNode = new Node(val);
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
	
	public void selectionSort() {
		for(Node i=head; i != null; i = i.next) {
			for(Node j=i.next; j != null; j = j.next) {
				if(i.data > j.data) {
					int temp = i.data;
					i.data = j.data;
					j.data = temp;
				}
			}
		}
	}
	
	public void reverse() {
		Node oldhead = head; // existing linked list
		head = null; // new linked list
		while(oldhead != null) {
			Node temp = oldhead;
			oldhead = oldhead.next;
			temp.next = head;
			head = temp;
		}
	}
	
	private void reverseDisplay(Node trav) {
		if(trav == null)
			return;
		reverseDisplay(trav.next);
		System.out.print(trav.data + ", ");
	}
	
	public void reverseDisplay() {
		System.out.print("Rev Display: ");
		reverseDisplay(head);
		System.out.println();
	}
	
	private void recReverse(Node trav) {
		if(trav.next == null) {
			head = trav;
			return;
		}
		recReverse(trav.next);
		trav.next.next = trav;
		trav.next = null;
	}
	
	public void recReverse() {
		if(head != null)
			recReverse(head);
	}
	
	public int findMiddle() {
		Node fast = head, slow = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow != null ? slow.data : 0;
	}
}

public class SinglyListSortingMain {
	public static void main(String[] args) {
		SinglyListSort l1 = new SinglyListSort();
		l1.addLast(30);
		l1.addLast(10);
		l1.addLast(40);
		l1.addLast(20);
		l1.display();
		l1.selectionSort();
		l1.display();
		l1.reverse();
		l1.display();
		l1.reverseDisplay();
		
		l1.display();
		l1.recReverse();
		l1.display();
		
		l1.addLast(50);
		l1.display();
		int res = l1.findMiddle();
		System.out.println("Middle : " + res);
	}
}
