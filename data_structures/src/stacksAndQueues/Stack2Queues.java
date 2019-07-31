package stacksAndQueues;

public class Stack2Queues<T> {
	private QueueUsingLL<T> main;
	private QueueUsingLL<T> extra;
	private int size;

	public Stack2Queues(){
		main = new QueueUsingLL<>();
		extra = new QueueUsingLL<>();
		size = 0;
	}

	public void push(T data){
		main.enqueue(data);
		size++;
	}
	public T pop() throws EmptyQueue, StackEmpty{
		if(size <= 0){
			StackEmpty e = new StackEmpty();
			throw e;
		}
		if(size > 1){
			main.reverse(extra);
			T temp = extra.dequeue();
			extra.reverse(main);
			size--;
			return temp;
		}else{
			size--;
			return main.dequeue();
		}
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public int sizeOf(){
		return size;
	}
}
