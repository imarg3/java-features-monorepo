package code;

class DoublyList {
	static class Node {
		private int data;
		private Node next;
		private Node prev;
		public Node() {
			data = 0;
			next = null;
			prev = null;
		}
		public Node(int val) {
			data = val;
			next = null;
			prev = null;
		}	
	}
	
	private Node head;
	private int count;
	
	public DoublyList() {
		head = null;
		count = 0;
	}
	
	public int getCount() {
		return count;
	}
	
	// time complexity - O(n)
	public void display() {
		Node temp = null;
		// display forward
		System.out.print("Fwd List: ");
		Node trav = head;
		while(trav != null) {
			System.out.print(trav.data + ", ");
			temp = trav;
			trav = trav.next;
		}
		System.out.println();
		// display reverse
		System.out.print("Rev List: ");
		trav = temp;
		while(trav != null) {
			System.out.print(trav.data + ", ");
			trav = trav.prev;
		}
		System.out.println();
	}
	
	// time complexity - O(n)
	public void addLast(int val) {
		Node newNode = new Node(val);
		
		if(head == null)
			head = newNode;
		else {
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			trav.next = newNode;
			newNode.prev = trav;
		}
		this.count++;
	}
	
	// time complexity - O(1)
	public void addFirst(int val) {
		Node newNode = new Node(val);
		
		if(head == null)
			head = newNode;
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		this.count++;
	}
	
	// time complexity - O(n)
	public void addAtPos(int val, int pos) {
		// spl3: add at last pos
		if(pos == count+1)
			addLast(val);
		// spl4: invalid pos
		else if(pos < 1 || pos > count+1)
			throw new RuntimeException("Invalid position " + pos);
		// spl1: list is empty or spl2: pos is 1
		else if(head == null || pos == 1)
			addFirst(val);
		else {
			Node newNode = new Node(val);
			// traverse till pos-1
			Node trav = head;
			for(int i=1; i<pos-1; i++)
				trav = trav.next;
			// mark its next node as temp
			Node temp = trav.next;
			// add newNode between trav & temp
			newNode.next = temp;
			newNode.prev = trav;
			trav.next = newNode;
			temp.prev = newNode;
			this.count++;
		}
	}
	
	// time complexity - O(1)
	public void delFirst() {
		// spl1: list is empty
		if(head == null)
			throw new RuntimeException("List is empty.");
		// spl2: if list have only one element
		if(head.next == null)
			head = null;
		else {
			head = head.next;
			head.prev = null;
		}
		this.count--;
	}
	
	// time complexity - O(n)
	public void delAtPos(int pos) {
		// spl1: list is empty or spl2: pos = 1
		if(head == null || pos == 1)
			delFirst();
		else {
			// spl3: invalid pos
			if(pos < 1 || pos > count)
				throw new RuntimeException("Invalid position " + pos);
			// traverse till pos
			Node trav = head;
			for (int i = 1; i < pos; i++)
				trav = trav.next;
			// delete trav node
			trav.prev.next = trav.next;
			if(trav.next != null) // spl4: if not last node to delete.
				trav.next.prev = trav.prev;
			this.count--;
		}
	}
	
	// time complexity - O(n)	
	public int countNodes() {
		int cnt = 0;
		Node trav = head;
		while(trav != null) {
			cnt++;
			trav = trav.next;
		}
		return cnt;
	}
}

public class DoublyListMain {
	public static void main(String[] args) {
		DoublyList obj = new DoublyList();
		obj.addLast(11);
		obj.addLast(22);
		obj.addLast(33);
		obj.addFirst(44);
		System.out.println("count = " + obj.getCount());
		obj.addAtPos(55, 5);
		System.out.println("count = " + obj.getCount());
		obj.display();
		obj.delFirst();
		obj.display();
		System.out.println("count = " + obj.getCount());
		obj.delAtPos(4);
		obj.display();
		System.out.println("count = " + obj.getCount());
		System.out.println("count = " + obj.countNodes());
	}
}

