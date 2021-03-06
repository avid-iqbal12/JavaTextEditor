package datastralgotuts;

import java.util.*;

/**
 * /Java program to create complete Binary Tree from its Linked List representation
*/

//A linked list node
class ListNode{
	int data;
	ListNode next;
	ListNode(int d){
		data = d;
		next = null;
	}
}

//A binary tree node
class BinaryTreeNode{
	int data;
	BinaryTreeNode left, right = null;
	
	BinaryTreeNode(int data){
     this.data = data;
     left = right = null;
	}
}

public class BSTwLL {
	ListNode head;
	BinaryTreeNode root;

	// Function to insert a node at the beginning of
	// the Linked List
	private BSTwLL push(int new_data){
		// allocate node and assign data
		ListNode new_node = new ListNode(new_data);
		// link the old list off the new node
		new_node.next = head;
		// move the head to point to the new node
		head = new_node;
		return this;
	}

	// converts a given linked list representing a 
	// complete binary tree into the linked 
	// representation of binary tree.
	private BinaryTreeNode convertList2Binary(BinaryTreeNode node){
		// queue to store the parent nodes
		Queue<BinaryTreeNode> queue = 
				new LinkedList<BinaryTreeNode>();

		// Base Case
		if (head == null){
         node = null; 
         return null;
		}

		// 1.) The first node is always the root node, and
		//     add it to the queue
		node = new BinaryTreeNode(head.data);
		queue.add(node);
		// advance the pointer to the next node
		head = head.next;

		// until the end of linked list is reached, do the
		// following steps
     	while (head != null){
     		// 2.a) take the parent node from the queue and 
     		//      remove it from queue
     		BinaryTreeNode parent = queue.peek();
     		BinaryTreeNode pp = queue.poll();
           
     		// 2.c) take next two nodes from the linked list.
     		// We will add them as children of the current 
     		// parent node in step 2.b. Push them into the
     		// queue so that they will be parents to the 
     		// future nodes
     		BinaryTreeNode leftChild = null, rightChild = null;
     		leftChild = new BinaryTreeNode(head.data);
     		queue.add(leftChild);
     		head = head.next;
     			if (head != null){
     				rightChild = new BinaryTreeNode(head.data);
     				queue.add(rightChild);
     				head = head.next;
	         }
     			
     		// 2.b) assign the left and right children of parent
     		parent.left = leftChild;
     		parent.right = rightChild;
     	}
     	return node;
	}

	// Utility function to traverse the binary tree 
	// after conversion
	private void inorderTraversal(BinaryTreeNode node){
		if (node != null){
			inorderTraversal(node.left);
			System.out.print(node.data + " ");
			inorderTraversal(node.right);
		}
	}

	// Driver program to test above functions
	public static void main(String[] args){
		BSTwLL tree = new BSTwLL();
			tree.push(36)
				.push(30)
				.push(25)
				.push(15)
				.push(12)
				.push(10)
				.push(5); /* last to first node of Linked List */
			BinaryTreeNode node = tree.convertList2Binary(tree.root);
			
			System.out.println("Inorder Traversal of the"+
                     " constructed Binary Tree is:");
			tree.inorderTraversal(node);
	}
}