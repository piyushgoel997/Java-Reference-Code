package stacksAndQueues;


public class Stack<T> {
	private node<T> head;
	private int size;
	
	public Stack(){
		size = 0;
		head = null;
	}
	
	public void push(T data){
		node<T> temp = new node<>(data);
		temp.next = head;
		head = temp;
		size++;
	}
	
	public T pop() throws StackEmpty{
		if(head == null){
			StackEmpty e = new StackEmpty();
			throw e;
		}
		node<T> temp = head;
		head = head.next;
		size--;
		return temp.data;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int sizeOf(){
		return size;
	}
	
	public T top(){
		node<T> temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		return temp.data;
	}
}
