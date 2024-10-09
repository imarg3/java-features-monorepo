package org.code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinSearchTree {
	static class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node() {
			data = 0;
			left = null;
			right = null;
		}
		
		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}
		
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}
	
	private Node root;
	public BinSearchTree() {
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
		
	public Node[] find(int val) {
		Node parent = null;
		Node trav = root;
		while(trav != null) {
			if(val == trav.data)
				return new Node[] {trav, parent};
			parent = trav;
			if(val < trav.data)
				trav = trav.left;
			else // if(val < trav.data)
				trav = trav.right;
		}
		return new Node[] {null, null};
	}
	
	public void delNode(int val) {
		// find the node to be deleted with its parent
		Node[] found = this.find(val);
		Node temp = found[0], parent = found[1];
		if(temp == null)
			throw new RuntimeException("Node Not Found.");
		// if node has parent & child node
		if(temp.left != null && temp.right != null) {
			parent = temp;
			Node succ = temp.right;
			while(succ.left != null) {
				parent = succ;
				succ = succ.left;
			}
			temp.data = succ.data;
			temp = succ;
		}
		// if node doesn't have left child
		if(temp.left == null) {
			if(temp == root)
				root = temp.right;
			else if(temp == parent.left)
				parent.left = temp.right;
			else //if(temp == parent.right)
				parent.right = temp.right;
			temp = null;
		}
		// else if node doesn't have right child
		else if(temp.right == null) {
			if(temp == root)
				root = temp.left;
			else if(temp == parent.left)
				parent.left = temp.left;
			else //if(temp == parent.right)
				parent.right = temp.left;
			temp = null;			
		}
	}
	
	public void depthFirstSearch() {
		System.out.print("DFS: ");
		Stack<Node> s = new Stack<Node>();
		s.push(this.root);
		while(!s.isEmpty()) {
			Node trav = s.pop();
			System.out.print(trav.data + ", ");
			if(trav.right != null)
				s.push(trav.right);
			if(trav.left != null)
				s.push(trav.left);
		}
		System.out.println();
	}
	
	public void breadthFirstSearch() {
		System.out.print("BFS: ");
		Queue<Node> q = new LinkedList<Node>();
		q.offer(this.root);
		while(!q.isEmpty()) {
			Node trav = q.poll();
			System.out.print(trav.data + ", ");
			if(trav.left != null)
				q.offer(trav.left);
			if(trav.right != null)
				q.offer(trav.right);
		}
		System.out.println();
	}
}

public class BinarySearchTreeAlgorithm {
	public static void main(String[] args) {
		BinSearchTree bst = new BinSearchTree();
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

		//bst.depthFirstSearch();
		//bst.breadthFirstSearch();
		
		bst.recInOrder();
		bst.delNode(50);
		bst.recInOrder();
	}
}

