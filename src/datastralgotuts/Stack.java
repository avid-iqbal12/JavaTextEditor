package datastralgotuts;

public interface Stack<T> extends Iterable<T>{
	T pop();
	void push (T item);
	boolean isEmpty();
	int size();
	//getTop();
}	
	/*private int top;	
	int size;
	int[] stack;
	
	public Stack(int arraySize){
		size = arraySize;
		stack = new int[size];
		top = -1;
	}	

	public void push(int value){
		if(top==size-1){
			System.out.println("Overflow");
		} else {
			top++;
			stack[top]=value;
		}		
	}
	
	public void pop(){
		if(!isEmpty())
			top--;
		else{
			System.out.println("Underflow");
		}
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
    
	public void display(){
		for(int i=0;i<=top;i++){
			System.out.println(stack[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		Stack nStack = new Stack(5);
		nStack.push(10);
		nStack.push(1);
		nStack.push(50);
		nStack.push(20);
		nStack.push(90);
		
		nStack.display();
		nStack.pop();
		nStack.pop();
		nStack.pop();
		nStack.pop();
		nStack.display();		
		*/
