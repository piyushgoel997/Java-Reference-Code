package stacksAndQueues;

public class QueueUsingLL<T> {
	private node<T> head, tail;
	private int size;
	
	public QueueUsingLL(){
		size = 0;
		head = null;
		tail = null;
	}
	
	public void enqueue(T element){
		if(head == null){
			head = new node<>(element);
			tail = head;
			size++;
		}else{
			node<T> temp = new node<>(element);
			tail.next = temp;
			tail = tail.next;
			size++;
		}
		
	}
	
	public T dequeue() throws EmptyQueue{
		if(head == null){
			EmptyQueue e = new EmptyQueue();
			throw e;
		}
		node<T> temp = head;
		head = head.next;
		size--;
		if(size == 0){
			head = null;
			tail = null;
		}
		return temp.data;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int size(){
		return size;
	}
	
	private node<T> reverse_helper(){
		if(head.next == null){
			return head;
		}
		node<T> reversed;
		node<T> temp = head;
		while(temp.next.next != null){
			temp = temp.next;
		}
		reversed = new node<>(temp.next.data);
		temp.next = null;
		reversed.next = reverse_helper();
		return reversed;
	}
	
	public void reverse(QueueUsingLL rev){
		rev.head = this.reverse_helper();
		node<T> tail = head;
		while(tail.next != null){
			tail = tail.next;
		}
		rev.tail = tail;
	}
}
