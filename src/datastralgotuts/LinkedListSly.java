package datastralgotuts;

/**A class that implements a singly linked list 
 * CSE 5003 - Data Structures -- Lesson on LinkedList (Iterative) 
 * @author Faisal Iqbal
 */

public class LinkedListSly {
	//head node of the list
	Node head;
	
	private static int count;
	
	/*insert to front of list
	public void push(int data){
		//1: Allocate the node
		//2: Put in the data
		Node new_node = new Node(data);
		//3: Make next of new node as head
		new_node.next = head;
		//4: Move the head pointer to new node
		head = new_node; 		
	}*/	
	
	// appends the specified element to the end of this list.
	public void add(Object data) {		 
		// Initialize Node only in case of 1st element
		if (head == null) {
			head = new Node(data);
		}
 
		Node new_node = new Node(data);
		Node temp = head;
		// Let's check for NPE before iterate over temp
		if (temp != null) {
			// starting at the head node, crawl to the end of the list and then add element after last node
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			// the last node's "next" reference set to our new node
			temp.setNext(new_node);
		}
		// increment the number of elements variable
		count++;
	}
 
	// inserts the specified element at the specified position in this list
	public void add(Object data, int index) {
		Node new_node = new Node(data);
		Node temp = head;
		// Let's check for NPE before iterate over temp
		if (temp != null) {
			// crawl to the requested index or the last element in the list, whichever comes first
			for (int i = 0; i < index && temp.getNext() != null; i++) {
				temp = temp.getNext();
			}
		}
		// set the new node's next-node reference to this node's next-node reference
		new_node.setNext(temp.getNext());
	 	// now set this node's next-node reference to the new node
		temp.setNext(new_node);
		// increment the number of elements variable
		count++;
	}
	 
	public Object get(int index)
	// returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if (index <= 0)
			return null;
		Node temp = null;
		if (head != null) {
			temp = head.getNext();
			for (int i = 0; i < index; i++) {
				if (temp.getNext() == null)
					return null;
 
				temp = temp.getNext();
			}
			return temp.getData();
		}
		return temp;
	}	
	
	// removes the element at the specified position in this list.
	public boolean remove(int index) {
		// if the index is out of range, exit
		if (index < 1 || index > getSize())
			return false;
	 
		Node temp = head;
		if (head != null) {
			for (int i = 0; i < index; i++) {
				if (temp.getNext() == null)
					return false;
					temp = temp.getNext();
				}
			temp.setNext(temp.getNext().getNext());
	 
			// decrement the number of elements variable
			count--;
			return true;
			}
		return false;
	}
	
	//return size of list||count of nodes in LL
	public int getSize(){
		count = 0;
		Node temp = head;
		while (temp!=null){ //traverse through list
			count++;
			temp = temp.next;
		}
		return count;
	}
		
	//print list as string
	public String toString() {
		String output = "";
		if (head != null) {
			Node temp = head.getNext();
			while (temp != null) {
				output += "[" + temp.getData().toString() + "]";
				temp = temp.getNext();
			}
		}
		return output;
	}
	
	public boolean isEmpty(){
		return head.next == null;
	}
	
    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

	
	public static void main(String[] args){
		//Start with an empty list
		LinkedListSly LList = new LinkedListSly();
		
		LList.add(1);
		LList.add(3);
		LList.add(4);
		LList.add(5);
		LList.add(6);
		LList.add(2, 1);
		
		System.out.println("Print List: \t\t" + LList);
		System.out.println("Is list empty?: \t" + LList.isEmpty());
		//System.out.println("Index[0]: \t\t" + LList.get(0));
		LList.remove(2);
		System.out.println("Print: List: \t\t" + LList);
		System.out.println("Get index[3]: \t\t" + LList.get(3));
		System.out.println("Size of current List: \t" + LList.getSize());
		System.out.println("Print again: \t\t" + LList);		
	} 
}
	
class Node {
		// reference to the next node in the chain, or null if there isn't one.
		Node next;
		
		// data carried by this node. could be of any type you need.
		Object data;
		 
		// Node constructor
		public Node(Object dataValue) {
			next = null;
			data = dataValue;
		}
		/* 
		// another Node constructor if we want to specify the node to point to.
		@SuppressWarnings("unused")
		public Node(Object dataValue, Node nextValue) {
			next = nextValue;
			data = dataValue;
		}
		*/ 
		// these methods should be self-explanatory
		public Object getData() {
			return data;
		}
		/* 
		@SuppressWarnings("unused")
		public void setData(Object dataValue) {
			data = dataValue;
		}
		*/ 
		public Node getNext() {
			return next;
		}
		 
		public void setNext(Node nextValue) {
			next = nextValue;
		}
}



