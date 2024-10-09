package org.code;

import java.util.Stack;

class BinarySearchTree {
	static class Node {
		private int data;
		private Node left;
		private Node right;
		private boolean visited;
		public Node() {
			data = 0;
			left = null;
			right = null;
			visited = false;
		}
		public Node(int val) {
			data = val;
			left = null;
			right = null;
			visited = false;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}

	private Node root;
	public BinarySearchTree() {
		root = null;
	}
	
	public void add(int val) {
		Node newNode = new Node(val);
		if(root == null)
			root = newNode;
		else {
			Node trav = root;
			while(true) {
				if(val < trav.data) {
					if(trav.left == null) {
						trav.left = newNode;
						break;
					} else
						trav = trav.left;
				} else { // if(val >= trav.data)
					if(trav.right == null) {
						trav.right = newNode;
						break;
					} else
						trav = trav.right;
				}
			}
		}
	}
	
	private void recAdd(Node trav, int val) {
		if(val < trav.data) {
			if(trav.left == null)
				trav.left = new Node(val);
			else
				recAdd(trav.left, val);
		} else {
			if(trav.right == null)
				trav.right = new Node(val);
			else
				recAdd(trav.right, val);
		}
	}
	public void recAdd(int val) {
		if(root == null)
			root = new Node(val);
		else
			recAdd(root, val);
	}
	
	private void recPreOrder(Node trav) {
		if(trav == null)
			return;
		System.out.print(trav.data + ", ");
		recPreOrder(trav.left);
		recPreOrder(trav.right);
	}
	
	public void recPreOrder() {
		System.out.print("Pre: ");
		recPreOrder(root);
		System.out.println();
	}

	private void recInOrder(Node trav) {
		if(trav == null)
			return;
		recInOrder(trav.left);
		System.out.print(trav.data + ", ");
		recInOrder(trav.right);
	}
	
	public void recInOrder() {
		System.out.print("In : ");
		recInOrder(root);
		System.out.println();
	}
	
	private void recPostOrder(Node trav) {
		if(trav == null)
			return;
		recPostOrder(trav.left);
		recPostOrder(trav.right);
		System.out.print(trav.data + ", ");
	}
	public void recPostOrder() {
		System.out.print("Post:");
		recPostOrder(root);
		System.out.println();
	}
	
	private void delTree(Node trav) {
		if(trav == null)
			return;
		delTree(trav.left);
		trav.left = null;
		delTree(trav.right);
		trav.right = null;
		trav = null;
	}
	public void delTree() {
		delTree(root);
		root = null;
	}
	
	private int recHeight(Node trav) {
		if(trav == null)
			return -1;
		int hl = recHeight(trav.left);
		int hr = recHeight(trav.right);
		int max = Integer.max(hl, hr);
		return max + 1;
	}
	public int recHeight() {
		return recHeight(root);
	}
	
	private Node recFind(Node trav, int val) {
		if(trav == null)
			return null;
		if(val == trav.data)
			return trav;
		if(val < trav.data)
			return recFind(trav.left, val);
		else
			return recFind(trav.right, val);
	}
	public Node recFind(int val) {
		return recFind(root, val);
	}
	
	public Node find(int val) {
		Node trav = root;
		while(trav != null) {
			if(val == trav.data)
				return trav;
			if(val < trav.data)
				trav = trav.left;
			else // if(val < trav.data)
				trav = trav.right;
		}
		return null;
	}
	
	
    void preOrder() {
        Stack<Node> s = new Stack<>();
        // 1. start traversing from root
        Node trav = root;
        System.out.print("PRE : ");
        while (trav != null || !s.isEmpty()) {
            while (trav != null) {
                // 2. visit trav
                System.out.print(trav.data + ", ");
                // 3. if trav has right, push trav.right on stack
                if (trav.right != null)
                    s.push(trav.right);
                // 4. go to left of trav
                trav = trav.left;
            } // 5. repeat 2-5 until trav is null
              // 6. pop Node from stack into trav
            if (!s.isEmpty())
                trav = s.pop();
        } // 7. repeat 2-6, until trav is null or stack is isEmpty
        System.out.println();
    }

    void inOrder() {
        Stack<Node> s = new Stack<>();
        Node trav = root;
        System.out.print("IN  : ");
        while (trav != null || !s.isEmpty()) {
            while (trav != null) {
                s.push(trav);
                trav = trav.left;
            }
            if (!s.isEmpty()) {
                trav = s.pop();
                System.out.print(trav.data + ", ");
                trav = trav.right;
            }
        }
        System.out.println();
    }

    void postOrder() {
        Stack<Node> s = new Stack<>();
        // start trav from root
        Node trav = root;
        System.out.print("POST: ");
        // while trav is not null or stack is not isEmpty
        while (trav != null || !s.isEmpty()) {
            // until null is reached
            while (trav != null) {
                // push trav on stack
                s.push(trav);
                // go to trav's left
                trav = trav.left;
            }
            // if stack is not isEmpty
            if (!s.isEmpty()) {
                // pop Node from stack into trav
                trav = s.pop();
                // if trav's right is present & visited
                if (trav.right == null || trav.right.visited == true) {
                    // visit trav & mark it as visited
                    System.out.print(trav.data + ", ");
                    trav.visited = true;
                    // make trav null (so that next Node will be popped from stack)
                    trav = null;
                }
                // otherwise
                else {
                    // push Node on stack
                    s.push(trav);
                    // go to its right
                    trav = trav.right;
                }
            }
        }
        System.out.println();
    }
}

public class BinarySearchTreeMain {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(50);
		bst.add(30);
		bst.add(10);
		bst.add(90);
		bst.add(100);
		bst.add(40);
		bst.add(70);
		bst.add(80);
		bst.add(20);
		bst.add(60);
		bst.delTree();

		bst.recAdd(50);
		bst.recAdd(30);
		bst.recAdd(10);
		bst.recAdd(90);
		bst.recAdd(100);
		bst.recAdd(40);
		bst.recAdd(70);
		bst.recAdd(80);
		bst.recAdd(20);
		bst.recAdd(60);
		
		bst.recPreOrder();
		bst.preOrder();
		bst.recInOrder();
		bst.inOrder();
		bst.recPostOrder();
		bst.postOrder();
		
		System.out.println("Height: " + bst.recHeight());
	
//		BinarySearchTree.Node temp = bst.recFind(75);
		BinarySearchTree.Node temp = bst.find(80);
		if(temp == null)
			System.out.println("Node not found.");
		else
			System.out.println("Node found: " + temp);
		
		bst.delTree();
		System.out.println("Height: " + bst.recHeight()); // -1	
	}
}
