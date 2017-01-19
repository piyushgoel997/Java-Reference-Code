package trees;

import stacksAndQueues.EmptyQueue;
import stacksAndQueues.QueueUsingLL;

public class BinarySearchTreeUse {

	// 4 2 6 1 3 5 7 -1 -1 -1 -1 -1 -1 -1 -1

	// 10 7 12 3 8 11 13 -1 -1 -1 -1 -1 -1 -1 -1
	public static void printBetween(BinaryTreeNode<Integer> root, int a, int b){
		if(root == null){
			return;
		}
		//		printBetween(root.left, a, b);
		//		printBetween(root.right, a, b);
		if(root.data > b){
			printBetween(root.right, a, b);
		}
		if(root.data < a){
			printBetween(root.left, a, b);
		}
		if(root.data >= a && root.data <= b){
			printBetween(root.left, a, b);
			System.out.print(root.data+" ");
			printBetween(root.right, a, b);
		}		
	}
	// 10 8 14 6 13 12 -1 -1 -1 -1 -1 -1 -1

	public static int max(BinaryTreeNode<Integer> root){
		if(root == null){
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(max(root.left), max(root.right)));
	}

	public static int min(BinaryTreeNode<Integer> root){
		if(root == null){
			return Integer.MAX_VALUE;
		}
		return Math.min(root.data, Math.min(min(root.left), min(root.right)));
	}

	public static boolean checkBST(BinaryTreeNode<Integer> root){
		if(root == null){
			return true;
		}

		int leftMax = max(root.left);
		int rightMin = min(root.right);

		if(root.data < leftMax || root.data > rightMin){
			return false;
		}
		if(!checkBST(root.left)){
			return false;
		}
		return checkBST(root.right);
	}

	public static boolean isBST(BinaryTreeNode<Integer> root, int min, int max){
		if(root == null){
			return true;
		}	
		if(!isBST(root.left, min, root.data)){
			return false;
		}
		if(!isBST(root.right, root.data, max)){
			return false;
		}
		if(root.data <= max && root.data >= min){
			return true;
		}else{
			return false;
		}
	}

	//TODO 0 -> 3 prob , sum -> prob on rt side
	public static void replaceWithSumOfGreater(BinaryTreeNode<Integer> root, int sum){
		if(root == null){
			return;
		}
		sum += sum(root.right);
		root.data += sum;
		replaceWithSumOfGreater(root.left, root.data);
		//		replaceWithSumOfGreater(root.right, 0);
		replaceWithSumOfGreater(root.right, sum);
	}

	// replace with sum of greater nodes, using LL, but complexity is high.
	public static void x(BinaryTreeNode<Integer> root, LLnode<Integer> bst){
		if(root == null){
			return;
		}
		LLnode<Integer> head = bst;
		// to reach root in the LL
		while(head.data != root.data){
			head = head.next;
		}
		// sum of greater nodes
		LLnode<Integer> temp = head;
		int sum = 0;
		while(temp != null){
			sum += temp.data;
			temp = temp.next;
		}
		root.data = sum;
		x(root.left, bst);
		x(root.right, head.next);
	}

	public static int sum(BinaryTreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		return root.data + sum(root.left) + sum(root.right); 
	}

	public static LLnode bstToLL(BinaryTreeNode<Integer> root){
		if(root == null){
			return null;
		}
		//		if(root.left != null){
		//			LLnode<Integer> prev = bstToLL(root.left);
		//
		//			LLnode<Integer> temp = prev;
		//			while(temp.next != null){
		//				temp = temp.next;
		//			}
		//			temp.next = new LLnode<Integer>(root.data);
		//			temp = temp.next;
		//			temp.next = bstToLL(root.right);
		//			return prev;
		//		}
		//		LLnode<Integer> temp = new LLnode<Integer>(root.data);
		//		if(root.right != null){
		//			temp.next = bstToLL(root.right);
		//		}
		//		return temp;

		LLnode<Integer> temp, current;
		if(root.left != null){
			LLnode<Integer> prev = bstToLL(root.left);
			current = prev;
			temp = prev;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = new LLnode<Integer>(root.data);
			temp = temp.next;
		}else{
			temp = new LLnode<Integer>(root.data);
			current = temp;
		}
		if(root.right != null){
			temp.next = bstToLL(root.right);
		}
		return current;

	}

	public static void printLevelWise(BinaryTreeNode<Integer> root) throws EmptyQueue{
		if(root == null){
			return;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pending = new QueueUsingLL<>();
		pending.enqueue(root);
		while(!pending.isEmpty()){
			BinaryTreeNode<Integer> temp = pending.dequeue();
			System.out.print(temp.data+" : ");
			if(temp.left != null){
				System.out.print(temp.left.data+" ");
				pending.enqueue(temp.left);
			}
			if(temp.right != null){
				System.out.print(temp.right.data+" ");
				pending.enqueue(temp.right);
			}
			System.out.println();
		}		
	}
	
	public static BinaryTreeNode<Integer> arrayToBST(int[] arr, int startIndex, int endIndex){
		if(startIndex > endIndex){
			return null;
		}
		int rootptr = (endIndex + startIndex)/2;
		// to inc rootptr by one if the length is even
		if((endIndex - startIndex)%2 == 1){
			rootptr++;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[rootptr]);
		root.left = arrayToBST(arr, startIndex, rootptr - 1);
		root.right = arrayToBST(arr, rootptr + 1, endIndex);
		return root;
	}

	public static void main(String[] args) throws EmptyQueue {
//		BinaryTreeNode<Integer> root = BinaryTreeUse.takeinput();
		//		printBetween(root, 4, 11);
		//		System.out.println(checkBST(root,root.left.data,root.right.data));

		//		LLnode<Integer> bst = bstToLL(root);
		//		while(bst != null){
		//			System.out.print(bst.data+" ");
		//			bst = bst.next;
		//		}

		//		System.out.println(isBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE));

		//		x(root, bst);
		//		printLevelWise(root);
		int arr[] = {1,2,3,4,5,6,7,8};
		BinaryTreeNode<Integer> root = arrayToBST(arr, 0, arr.length - 1);
		printLevelWise(root);
	}

}
