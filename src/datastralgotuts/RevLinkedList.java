package datastralgotuts;

public class RevLinkedList {

	static Node head;
	
	static class Node{
		int data; 
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	// Iterative Reverse
	Node reverse(Node node){
		Node prev = null;
		Node current = node;
		Node next = null;
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;		
	}
	// Recursive Reverse
	Node Reverse(Node node)
	{
	    if (node == null) return null; // first question

	    if (node.next == null) return node; // second question

	    // third question - in Lisp this is easy, but we don't have cons
	    // so we grab the second element (which will be the last after we reverse it)

	    Node secondElem = node.next;

	    // bug fix - need to unlink list from the rest or you will get a cycle
	    node.next = null;

	    // then we reverse everything from the second element on
	    Node reverseRest = Reverse(secondElem);

	    // then we join the two lists
	    secondElem.next = node;

	    return reverseRest;
	}
	
	void printList(Node node){
		while(node!=null){
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		RevLinkedList list = new RevLinkedList();
		list.head = new Node(85);
		list.head.next = new Node(15); 
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);
		
		System.out.println("Original linked list is: ");
		list.printList(head);
		head = list.reverse(head);
		//head = list.Reverse(head);
		System.out.println("");
		System.out.println("Reversed linked list is: ");
		list.printList(head);
	}
}