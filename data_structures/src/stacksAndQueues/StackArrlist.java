package stacksAndQueues;

import java.util.ArrayList;

public class StackArrlist<T> {
	ArrayList<T> arr;
	int top;
	
	public StackArrlist(){
		arr = new ArrayList<>();
		top = -1;
	}
	
	public void push(T data){
		arr.add(++top, data);
	}
	
	public T pop(){
		T temp =arr.get(top);
		arr.remove(top--);
		return temp;
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public int size(){
		return top + 1;
	}
}
