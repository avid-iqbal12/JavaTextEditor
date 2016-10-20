package datastralgotuts;
/**
 * Represents the Binary Search Tree.
 */
public class BinaryTree {
	//Reference for the root of the tree.
	public TreeNode root;
/**--TreeNode-- 
	The binary tree is built using this nested node class. 
	Each node stores one data element, and has left and right 
	sub-tree pointer which may be null. 
	The node is a "dumb" nested class -- we just use it for 
	storage; it does not have any methods. 
*/ 
	public static class TreeNode {	
		int data;		//The data present in the node.
		TreeNode left;	//The reference to the left subtree.	
		TreeNode right;	//The reference to the right subtree.
		
		private TreeNode(int newData) {
			this.data = newData;
		}
	}
/** 
	Recursive insert -- given a node pointer, recur down and 
	insert the given data into the tree. Returns the new 
	node pointer (the standard way to communicate 
   	a changed pointer back to the caller). 
*/ 
	public BinaryTree insert(int data) {
    TreeNode node = new TreeNode(data);
    	if (root == null) {
    		root = node;
    		return this;
    	}
    	insertRec(root, node);
    	return this;
	}
	//helper method
	private void insertRec(TreeNode latestRoot, TreeNode node) {
		if (latestRoot.data > node.data){
			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}

// Returns the minimum value in the Binary Search Tree
	public int findMinimum() {
		if (root == null) {
			return 0;
		}
		TreeNode currNode = root;
		while (currNode.left != null) {
			currNode = currNode.left;
    	}
		return currNode.data;
	}

//Returns the maximum value in the Binary Search Tree
	public int findMaximum() {
		if (root == null) {
			return 0;
		}
		TreeNode currNode = root;
		while (currNode.right != null) {
			currNode = currNode.right;
		}
		return currNode.data;
	}

//Printing the contents of the tree in an in order way.
	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");	  
	}
//Helper method to recursively print the contents in an inorder way
	private void printInOrderRec(TreeNode currRoot) {
		if (currRoot == null) {
			return;
		}
		printInOrderRec(currRoot.left);
		System.out.print(currRoot.data + ", ");
		printInOrderRec(currRoot.right);
	}

//Printing the contents of the tree in a Preorder way.
	public void printPreorder() {
		printPreOrderRec(root);
		System.out.println("");
	}
//Helper method to recursively print the contents in a Preorder way
	private void printPreOrderRec(TreeNode currRoot) {
		if (currRoot == null) {
			return;
		}
		System.out.print(currRoot.data + ", ");
		printPreOrderRec(currRoot.left);
		printPreOrderRec(currRoot.right);
	}

//Printing the contents of the tree in a Postorder way.

	public void printPostorder() {
		printPostOrderRec(root);
		System.out.println("");
	}

//Helper method to recursively print the contents in a Postorder way
	private void printPostOrderRec(TreeNode currRoot) {
		if (currRoot == null) {
			return;
		}
		printPostOrderRec(currRoot.left);
		printPostOrderRec(currRoot.right);
		System.out.print(currRoot.data + ", ");
	}

	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();
		bst.insert(40)
			.insert(25)
			.insert(78)
			.insert(10)
			.insert(3)
			.insert(17)
			.insert(32)
			.insert(30)
			.insert(38)
			.insert(78)
			.insert(50)
			.insert(93);
		System.out.println("Inorder traversal");
		bst.printInorder();
    
		System.out.println("Preorder Traversal");
		bst.printPreorder();
   
		System.out.println("Postorder Traversal");
		bst.printPostorder();

		System.out.println("\n" + "The minimum value in the BST: " + bst.findMinimum()); 
		System.out.println("\n" + "The maximum value in the BST: " + bst.findMaximum());
    
	}
}