package trees;


import java.util.Scanner;

import stacksAndQueues.EmptyQueue;
import stacksAndQueues.QueueUsingLL;
import stacksAndQueues.Stack;
import stacksAndQueues.StackEmpty;

public class TreeUse {

	public static TreeNode<Integer> takeinput() throws EmptyQueue{
		TreeNode<Integer> root;
		System.out.println("Enter root data: ");
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		root = new TreeNode<Integer>(data);
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentnode = pendingNodes.dequeue();
			System.out.println("enter the no of children of "+currentnode.data);
			int i = s.nextInt();
			for(int j = 0; j < i; j++){
				System.out.println("enter "+j+" child");
				data = s.nextInt();
				TreeNode<Integer> child = new TreeNode<Integer>(data);
				currentnode.children.add(child);
				pendingNodes.enqueue(child);
			}
		}
		return root;
	}

	public static void print(TreeNode<Integer> root) throws EmptyQueue{
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentnode = pendingNodes.dequeue();
			String str = currentnode.data+" : ";
			for(int i = 0; i < currentnode.children.size(); i++){
				TreeNode<Integer> child = currentnode.children.get(i);
				str += child.data + ",";
				pendingNodes.enqueue(child);
			}
			System.out.println(str);
		}
	}
	// 1 2 2 3 2 4 5 2 6 7 0 0 0 0
	public static int noOfNodes(TreeNode<Integer> root){
		if(root == null){
			return -1;
		}
		if(root.children.size() == 0){
			return 1;
		}
		int count = 1;
		for(int i = 0; i < root.children.size(); i++){
			count += noOfNodes(root.children.get(i));
		}
		return count;
	}

	public static int sumOfNodes(TreeNode<Integer> root){
		if(root == null){
			return -1;
		}
		if(root.children.size() == 0){
			return root.data;
		}
		int sum = root.data;
		for(int i = 0; i < root.children.size(); i++){
			sum += sumOfNodes(root.children.get(i));
		}
		return sum;
	}

	public static TreeNode<Integer> largestNode(TreeNode<Integer> root){
		if(root == null){
			return null;
		}
		//		if(root.children.size() == 0){
		//			return root;
		//		}
		TreeNode<Integer> max = root;
		for(int i = 0; i < root.children.size(); i++){
			TreeNode<Integer> temp = largestNode(root.children.get(i));
			if(temp.data > max.data){
				max.data = temp.data;
			}
		}
		return max;
	}

	public static int heightOf(TreeNode<Integer> root){
		if(root == null){
			return -1;
		}
		if(root.children.size() == 0){
			return 1;
		}
		int max = 0;//heightOf(root.children.get(0)) + 1;
		//		for(int i = 1; i < root.children.size(); i++){
		//			int temp = heightOf(root.children.get(i)) + 1;
		//			if(max < temp){
		//				max = temp;
		//			}
		//		}
		for(TreeNode<Integer> element: root.children){
			int temp = heightOf(element) + 1;
			if(max < temp){
				max = temp;
			}
		}
		return max;
	}

	public static int greaterNodes(TreeNode<Integer> root, int x){
		if(root == null){
			return -1;
		}
		int count = 0;
		if(root.data > x){
			count++;
		}
		for(TreeNode<Integer> element : root.children){
			count += greaterNodes(element, x);			
		}
		return count;
	}

	public static sumPair maxSum(TreeNode<Integer> root){
		if(root == null){
			return null;
		}
		int sum = root.data;
		for(TreeNode<Integer> element : root.children){
			sum += element.data;
		}
		sumPair ans = new sumPair(root,sum);
		for(TreeNode<Integer> element : root.children){
			sumPair temp = maxSum(element);
			if(temp.sum > sum){
				ans = temp;
			}
		}
		return ans;
	}

	/*public static TreeNode<Integer> maxSum(TreeNode<Integer> root){
		if(root == null){
			return null;
		}
		TreeNode<Integer> max = root;
		int sum = 0;
		for(TreeNode<Integer> element : root.children){
			sum += element.data;
		}
		for(TreeNode<Integer> element : root.children){
			TreeNode<Integer> temp = maxSum(element);
			if(sum < temp.data){
				max = element;
			}
		}
		return max;
	}*/

	public static void printAtDepth(TreeNode<Integer> root,int k){
		if(root == null){
			return;
		}
		if(k == 0){
			System.out.print(root.data+" ");
		}
		for(TreeNode<Integer> element: root.children){
			printAtDepth(element, k-1);
		}
	}

	public static boolean checkIdentical(TreeNode<Integer> a, TreeNode<Integer> b){
		if(a == null){
			return true;
		}
		if(a.data == b.data){
			if(a.children.size() == b.children.size()){
				for(int i = 0; i < a.children.size(); i++){  // Dead code why??
					if(!checkIdentical(a.children.get(i), b.children.get(i))){
						return false;
					}
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
		return true;
	}

	public static int noOfLeaves(TreeNode<Integer> root){
		if(root == null){
			return -1;
		}
		if(root.children.size() == 0){
			return 1;
		}
		int count = 0;
		for(TreeNode<Integer> element : root.children){
			count += noOfLeaves(element);
		}
		return count;
	}

	public static void replaceWithDepth(TreeNode<Integer> root, int depth){
		if(root == null){
			return;
		}
		root.data = depth;
		for(TreeNode<Integer> element : root.children){
			replaceWithDepth(element, depth+1);
		}
	}

	// without recursion
	public static TreeNode<Integer> secondLargest(TreeNode<Integer> root) throws EmptyQueue{
		if(root == null){
			return null;
		}
		TreeNode<Integer> largest = new TreeNode<Integer>(Integer.MIN_VALUE), secondlargest = new TreeNode<Integer>(Integer.MIN_VALUE);
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> temp = pendingNodes.dequeue();
			for(TreeNode<Integer> element : temp.children){
				pendingNodes.enqueue(element);
			}
			if(temp.data > largest.data){
				secondlargest = largest;
				largest = temp;
			}else if(temp.data > secondlargest.data){
				secondlargest = temp;
			}
		}
		return secondlargest;
	}

	/*	public static NodePair secondLargestRec(TreeNode<Integer> root){
		if(root == null){
			return null;
		}
		if(root.children.size() == 1){
			TreeNode<Integer> temp = new TreeNode<>(Integer.MIN_VALUE);
			NodePair ans = new NodePair(root,temp);
			return ans;
		}
		int max = Integer.MIN_VALUE, sec = Integer.MIN_VALUE;
		for(TreeNode<Integer> element : root.children){
			NodePair temp = secondLargestRec(element);
//			if(root.data > temp.largest.data){
//				temp.secondLargest = temp.largest;
//				temp.largest = root;
//			}else if(root.data > temp.secondLargest.data){
//				temp.secondLargest = root;
//			}
//			ans = temp;
			if(temp.largest.data > max){
				max = temp.largest.data;
			}
			if(temp.largest.data)
		}
		return ans;
	}*/
	 
	public static TreeNode<Integer> removeLeaves(TreeNode<Integer> root){
		if(root == null){
			return null;
		}
		int i = 0;
		while(i < root.children.size()){
			TreeNode<Integer> element = root.children.get(i);
			if(element.children.size() == 0){
				root.children.remove(i);
			}else{
				removeLeaves(element);
				i++;
			}
		}
		return root;
	}

	public static TreeNode<Integer> removeLeaves2(TreeNode<Integer> root){
		if(root.children.size() == 0){
			root = null;
		}
		for(TreeNode<Integer> child : root.children){
			child = removeLeaves(child);
		}
		return root;
	}

	public static void preOrderI(TreeNode<Integer> root) throws StackEmpty{
		Stack<TreeNode<Integer>> pending = new Stack<>();
		pending.push(root);
		while(!pending.isEmpty()){
			TreeNode<Integer> temp = pending.pop();
			System.out.print(temp.data+" ");
			for(int i = temp.children.size() - 1; i >= 0; i--){
				pending.push(temp.children.get(i));
			}
		}
	}

	public static void preOrderR(TreeNode<Integer> root){
		if(root == null){
			return;
		}
		System.out.print(root.data+" ");
		for(TreeNode<Integer> child : root.children){
			preOrderR(child);
		}
	}

	// returns max int if no ans is present in the tree
	public static TreeNode<Integer> justGreater(TreeNode<Integer> root, int k){
		if(root == null){
			return null;
		}
		if(root.children.size() == 0){
			//			if(root.data > k){
			return root;
			//			}else{
			//				return null;    // Gives null pointer exception
			//			}
		}
		TreeNode<Integer> ans = new TreeNode<>(Integer.MAX_VALUE);
		if(root.data > k){
			ans.data = root.data;
		}
		for(TreeNode<Integer> element : root.children){
			TreeNode<Integer> temp = justGreater(element, k);
			if(temp.data < ans.data && temp.data > k){
				ans.data = temp.data;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws EmptyQueue, StackEmpty {
		TreeNode<Integer> root = takeinput();
		//		TreeNode<Integer> b = takeinput();
		//		print(root);
		//		System.out.println(heightOf(root));
		//		printAtDepth(root, 2);
		//		replaceWithDepth(root, 0);
		//		print(root);
		//		System.out.println();
		//		System.out.println(greaterNodes(root, 4));
		//		System.out.println(maxSum(root).node.data);
		//		System.out.println(checkIdentical(root, b));
		//		System.out.println(nextLargerElement(root, 4).data);
		//		System.out.println(noOfLeaves(root));
		//		System.out.println(justGreater(root, 5).data);
		//		System.out.println(secondLargest(root).data);
		//		System.out.println(secondLargestRec(root).secondLargest.data);
		if(removeLeaves2(root) == null){
			System.out.println("null");
		}else{
			print(removeLeaves2(root));
		}
		//		preOrderI(root);		
	}
}
