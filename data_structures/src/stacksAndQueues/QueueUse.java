package stacksAndQueues;

public class QueueUse {

	public static void main(String[] args) throws StackEmpty, EmptyQueue {
		Queue2Stacks<Integer> q = new Queue2Stacks<>();
//		QueueUsingLL<Integer> q = new QueueUsingLL<>();
//		QueueUsingLL<Integer> rev = new QueueUsingLL<>();
		for(int i = 1; i < 5; i++){
			q.enqueue(i);
		}
//		q.reverse(rev);
//		while(!rev.isEmpty()){
//			System.out.println(rev.dequeue());
//		}
//		System.out.println();
		while(!q.isEmpty()){
			System.out.println(q.dequeue());
		}
	}

}
