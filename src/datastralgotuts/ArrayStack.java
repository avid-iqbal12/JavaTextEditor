package datastralgotuts;

import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {

	private T container[];
	private int top;
	private final static int DEFAULT_SIZE = 10;
	
	public ArrayStack(){
		this(DEFAULT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int initSize){
		container = (T[]) new Object [initSize];
		top = -1;
	}
	@Override
	public Iterator<T> iterator() {
		return new ArrayStackIterator();
	}
	private class ArrayStackIterator implements Iterator<T>{
		private int i = top;
		@Override
		public boolean hasNext() {
			return (i > -1);
		}
		@Override
		public T next() {
			return container[i--];
		}
		public void remove(){
			//not needed
		}
	}
	
	@Override
	public T pop() {
		if(top==-1)
			System.out.println("Underflow");
		return container[top--];
	}
	@Override
	public void push(T item) {
		container[++top] = item;		
	}
	@Override
	public boolean isEmpty() {
		return (top==-1);
	}
	@Override
	public int size() {
		return (top+1);
	}
	
	public static void main(String[] args){
		Stack <Integer> s = new ArrayStack<Integer>();
	    s.push(20);
	    s.push(30);
	    s.push(40);
	    s.push(50);
	    s.push(60);
	    s.push(70);
	 
	    System.out.println("Size of the stack: " + s.size());
	 
	    // iterate through stack
	    System.out.println("Following items pushed to Stack as of now:");
	    for (Integer i : s)
	      System.out.println(i);	
	}

}

