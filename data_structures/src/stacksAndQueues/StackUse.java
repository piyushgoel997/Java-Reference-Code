package stacksAndQueues;

public class StackUse {

	public static void main(String[] args) throws StackEmpty, EmptyQueue {
		// TODO Auto-generated method stub
		Stack2Queues<Integer> s = new Stack2Queues<>();
		for(int i = 0; i < 5; i++){
			s.push(i);
		}
		
		
		while(!s.isEmpty()){
			
				System.out.println(s.pop());
			
		}
		System.out.println(s.sizeOf());		
	}

}
