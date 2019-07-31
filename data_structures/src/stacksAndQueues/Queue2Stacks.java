package stacksAndQueues;

public class Queue2Stacks<T> {
	private Stack<T> main;
	private Stack<T> extra;
	private int size;

	public Queue2Stacks(){
		main = new Stack<T>();
		extra = new Stack<T>();
		size = 0;
	}

	public void enqueue(T data){
		main.push(data);
		size++;
	}

	public T dequeue() throws StackEmpty{
		while(!main.isEmpty()){
				extra.push(main.pop());
		}
		T temp = (T) extra.pop();
		while(!extra.isEmpty()){
			main.push(extra.pop());
		}
//		main = extra;
//		extra = new Stack<>();
		size--;
		return temp;
	}
		
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int sizeOf(){
		return size;
	}
}
