package datastralgotuts;

import java.util.*;

public class LinkedStack<T> implements Stack<T> {	
	private Node head; //first node
	private int size; // num of items

	//nested class to define node
	private class Node{
		T item;
		Node next;
	}
	
	//Zero argument constructor
	public LinkedStack(){
		head = null;
		size = 0;
	}
	
	@Override
	public T pop() {
		 T item = head.item;
		 head = head.next;
		 size--;
		 return item;
	}

	@Override
	public void push(T item) {
		Node oldHead = head;
		head = new Node();
		head.item = item;
		head.next = oldHead;
		size++;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	//iterator for traversing stack items
	public Iterator<T> iterator() {
		return new LinkedStackIterator();
	}
	
	//
	private class LinkedStackIterator implements Iterator <T>{
		private int i = size;
		private Node first = head; // the first node		
		public boolean hasNext(){
			return (i>0);
		}
		public T next(){
			T item = first.item;
			first = first.next;
			i--;
			return item;
		}
		public void remove(){
			//not needed;
		}
	}
	
	public static void main(String[] args){
		Stack <Integer> s = new LinkedStack<Integer>();
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		s.push(80);
		s.pop();
		
		System.out.println("Size of the stack: " + s.size());
		
		//iterate through stack
		System.out.println("Stack contains:");
		for (Integer i : s)
			System.out.println(i);
	}
}
