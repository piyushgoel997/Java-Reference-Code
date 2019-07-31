import java.util.Scanner;

public class LinkedList {

	public static node<Integer> takeinput(){
		Scanner s = new Scanner(System.in);
		System.out.println("enter data");
		int data = s.nextInt();
		node<Integer> head = null;
		node<Integer> tail = null;
		while(data != -1){
			node<Integer> newNode = new node<>(data);
			if(head == null){
				head = newNode;
				tail = head;
			}else{
				tail.next = newNode;
				tail = newNode;
			}	
			data = s.nextInt();
		}
		return head;
	}

	public static int length(node<Integer> head){
		return (head == null) ? 0 : 1 + length(head.next);
	}

	public static void printLL(node<Integer> head){
		while(head != null){
			System.out.print(head.data+"->");
			head = head.next;
		}
		System.out.println();
	}

	public static void printElement(node<Integer> head,int i){
		int count = 0;
		while(count < i){
			count++;
			head = head.next;
		}
		System.out.println(head.data);
	}

	public static node<Integer> insertElement(node<Integer> head, int i, int data){
		if(i == 0){
			node<Integer> newHead = new node<Integer>(data);
			newHead.next = head;
			return newHead;
		}else{
			int count = 0;
			node<Integer> temp = new node<>(data);
			node<Integer> newHead;
			newHead = head;
			while(count < i -1){
				count++;
				head = head.next;
			}
			temp.next = head.next;
			head.next = temp;
			return newHead;
		}
	}

	public static node<Integer> delElement(node<Integer> head, int i){
		if(i == 0){			
			return head.next;			
		}else{
			int count = 0;
			node<Integer> newHead = head;
			while(count < i -1){
				count++;
				head = head.next;
			}
			node<Integer> temp = head.next;
			head.next = temp.next;
			return newHead;
		}
	}

	public static int lenLLRec(node<Integer> head){
		if(head == null){
			return 0;
		}		
		return 1 + lenLLRec(head.next);
	}

	public static node<Integer> delRec(node<Integer> head, int i){
		if(i == 0){
			return head.next;
		}
		node<Integer> temp = delRec(head.next, i-1);;
		head.next = temp;
		return head;
	}

	public static node<Integer> insRec(node<Integer> head, int i, int data){
		if(i == 0){
			node<Integer> newNode = new node<>(data);
			newNode.next = head;
			head = newNode;
			return head;
		}
		node<Integer> temp = insRec(head.next, i-1, data);;
		head.next = temp;
		return head;
	}

	public static int findElement(node<Integer> head, int element){
		if(head.data == element){
			return 0;
		}
		return 1 + findElement(head.next, element);
	}

	public static node<Integer> mergeLL(node<Integer> a, node<Integer> b){
		node<Integer> current;
		node<Integer> aPointer = a, bPointer = b;
		boolean flag;
		if(a.data < b.data){
			current = a;
			aPointer = aPointer.next;
			flag = true;
		}else{
			current = b;
			bPointer = bPointer.next;
			flag = false;
		}
		while(aPointer != null && bPointer != null){
			if(aPointer.data < bPointer.data){
				current.next = aPointer;
				current = aPointer;
				aPointer = aPointer.next;
			}else{
				current.next = bPointer;
				current = bPointer;
				bPointer = bPointer.next;
			}	
		}
		if(aPointer == null){
			current.next = bPointer;
		}
		if(bPointer == null){
			current.next = aPointer;
		}
		if(flag){
			return a;
		}else{
			return b;
		}
	}

	public static node<Integer> reverseLL(node<Integer> head){
		node<Integer> prev = head.next;
		node<Integer> current = prev;
		head.next = null;
		while(current != null){
			current = current.next;
			prev.next = head;
			head = prev;
			prev = current;			
		}
		return head;		
	}

	public static node<Integer> reverseRec(node<Integer> head, node<Integer> current){
		if(current == null){
			return head;
		}
		if(head.next == current){
			head.next = null;
		}
		node<Integer> prev = current;
		current = current.next;
		prev.next = head;
		head =  reverseRec(prev,current);
		return head;
	}

	public static node<Integer> mergeSort(node<Integer> head){
		if(head.next == null){
			return head;
		}
		node<Integer> end = null, nextll = head;
		int len = length(head), i = 0;
		while(i < len/2){
			end = nextll;
			nextll = nextll.next;
			i++;
		}
		end.next = null;
		head = mergeSort(head);
		nextll = mergeSort(nextll);
		node<Integer> newhead = mergeLL(head, nextll);
		return newhead;
	}
	
	public static node<Integer> insertionSort(node<Integer> head){
		if(head == null || head.next ==null){
			return head;
		}
		node<Integer> temp = head, prev = null;
		while(temp.next != null){
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
		head = insertionSort(head);
		head = mergeLL(head, temp);
		return head;
	}
	
	public static node<Integer> oddeven(node<Integer> head){
		node<Integer> oddhead = head, oddtail,evenhead = head, eventail, temp;
		int i = 0, j = 0;
		while(oddhead.data%2 != 1){
			oddhead = oddhead.next;
			i++;
		}
		while(evenhead.data%2 != 0){
			evenhead = evenhead.next;
			j++;
		}
		if(j < i){
			head = swap(head,i,j);
		}
		oddtail = oddhead;
		eventail = evenhead;
		while(oddtail.next != evenhead){
			oddtail =  oddtail.next;
		}
		temp = eventail.next;
		while(temp != null){
			if(temp.data%2 == 0){
				eventail = eventail.next;
				temp = temp.next;
			}else{
				eventail.next = temp.next;
				oddtail.next = temp;
				temp.next = evenhead;
				oddtail = oddtail.next;
				temp = eventail.next;
			}				
		}
		return oddhead;
	}

	public static node<Integer> selSort(node<Integer> head){
		if(head.next == null){
			return head;
		}

		node<Integer> temp = head;
		node<Integer> min = head;
		int count = 0, savedcount = 0;
		//TODO not working as temp is stuck at one place and fn goes into infinite loop.
		while(temp != null){
			if(temp.data < min.data){
				savedcount = count;
				min = temp;
			}
			temp = temp.next;
			count++;
		}
		head = swap(head,0,savedcount);		
		head.next = selSort(head.next);
		return head;
	}

	// changes the input LL.
	public static boolean checkPalindrome(node<Integer> head){
		if(head.next == null){
			return true;
		}
		node<Integer> temp = head.next, prev = head;
		while(temp.next != null){
			prev = prev.next;
			temp = prev.next;
		}
		if(temp.data == head.data){
			prev.next = null;
			if(head.next != null){
				return checkPalindrome(head.next);
			}else{
				// for case of 2 2
				return true;
			}
		}
		return false;
	}

	public static node<Integer> swap(node<Integer> head, int i, int j){
		int count = 0;
		node<Integer> other = head;
		node<Integer> newhead = head;
		while(count < i-1){
			head = head.next;
			count++;
		}
		count = 0;
		while(count < j-1){
			other = other.next;
			count++;
		}

		if(i == 0 || j == 0){
			// for swapping head with its next term
			if(i - j == 1 || j - i == 1){
				other = other.next;
				node<Integer> temp = other.next;
				other.next = head;
				head.next = temp;
				return other;
				
			}else{//for swapping head with another term
				node<Integer> temp = other.next;
				node<Integer> temp2 = head.next;
				head.next = temp.next;
				other.next = head;
				temp.next = temp2;
				return temp;
			}
		}
		node<Integer> temp = head.next;
		head.next = other.next;
		other.next = temp;
		temp = temp.next;
		other.next.next = head.next.next;
		head.next.next = temp;
		return newhead;
	}

	public static void eleminateDuplicates(node<Integer> head){
		if(head == null){
			return;
		}
		node<Integer> temp = head.next;
		if(head.data == temp.data){
			head.next = temp.next;
		}
		eleminateDuplicates(head.next);
	}

	public static int midpoint(node<Integer> head){
		int count = 0;
		while(head.next != null){
			head = head.next;
			count++;
		}
		return count/2;
	}

	public static void printRev(node<Integer> head){
		node<Integer> temp = head;
		int length = length(head);		
		while(length > 0){
			temp = head;
			int count = 0;
			while(count < length){
				temp = temp.next;				
				count++;
			}
			System.out.print(temp.data);
			length--;
		}
		System.out.println(head.data);
	}

	public static node<Integer> appendLastN(node<Integer> head, int n){
		node<Integer> temp = head, newhead = head, end = head;
		int length = 0;
		while(temp.next != null){
			temp = temp.next;
			length++;
		}
		int i = 0;
		while(i <= length - n){
			end = newhead;
			newhead = newhead.next;
			i++;

		}
		temp.next = head;
		end.next = null;
		return newhead;
	}

	public static node<Integer> kreverse(node<Integer> head, int k){
		if(head == null || head.next == null){
			return head;
		}
		node<Integer> nexthead = head, end = null;
		int i = 0;
		while(i < k && nexthead != null){
			end = nexthead;
			nexthead = nexthead.next;
			i++;
		}
		end.next = null;
		head = reverseLL(head);
		end = head;
		while(end.next != null){
			end = end.next;
		}
		end.next = kreverse(nexthead, k);
		return head;
	}

	public static node<Integer> findElementRec(node<Integer> head, int num){
		if(head == null ){
			return null;
		}
		if(head.data == num){
			return head;
		}
		return findElementRec(head.next, num);
	}

	public static node<Integer> findMid(node<Integer> head){
		if(head == null){
			return null;
		}
		node<Integer> slow = head;
		node<Integer> fast = head;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		node<Integer> head = takeinput();
		//		node<Integer> a = takeinput();

		//		printLL(head);
		//		System.out.println(lengthLL(head));
		//		printElement(head, 2);
		//		head = delRec(head, 2);
		//		printLL(head);
		//		System.out.println(lenLLRec(head));
		//		System.out.println(findElement(head, 3));

		//				printLL(mergeLL(head, a));
		//		mergeSort(head, head.next);

//				head = swap(head,0,3);
		//		eleminateDuplicates(head);

		//		printLL(head);
		//		System.out.println(midpoint(head));
		//		printLL(reverseRec(head, head.next));

		//		System.out.println(checkPalindrome(head));

		//		printRev(head);
		//		printLL(kreverse(head, 4));
		//		System.out.println(findElementRec(head, 5));
		//		printLL(mergeSort(head));
				head = insertionSort(head);
//		head = oddeven(head);
		printLL(head);

	}
}
