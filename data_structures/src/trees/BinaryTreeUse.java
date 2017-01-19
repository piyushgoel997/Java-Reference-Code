package trees;

import java.util.Scanner;

import stacksAndQueues.EmptyQueue;
import stacksAndQueues.QueueUsingLL;

public class BinaryTreeUse {

	public static BinaryTreeNode<Integer> takeinput() throws EmptyQueue{
		QueueUsingLL<BinaryTreeNode<Integer>> pending = new QueueUsingLL<>();
		Scanner s = new Scanner(System.in);
		System.out.println("enter root data: ");
		int rootdata = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
		pending.enqueue(root);
		while(!pending.isEmpty()){
			BinaryTreeNode<Integer> temp = pending.dequeue();
			System.out.println("enter left data of "+temp.data);
			int leftdata = s.nextInt();
			if(leftdata != -1){
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftdata);
				temp.left = left;
				pending.enqueue(left);
			}

			System.out.println("enter right data of "+temp.data);
			int rightdata = s.nextInt();
			if(rightdata != -1){
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightdata);
				temp.right = right;
				pending.enqueue(right);
			}
		}
		return root;
	}
	// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
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

	public static void mirror(BinaryTreeNode<Integer> root){
		if(root == null){
			return;
		}
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror(root.left);
		mirror(root.right);
	}

	public static int dia(BinaryTreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		int ans = left + right + 1;
		if(ans < dia(root.right)){
			ans = dia(root.right);
		}
		if(ans < dia(root.left)){
			ans = dia(root.left);
		}
		return ans;
	}

	public static DiaPair diameter(BinaryTreeNode<Integer> root){
		if(root == null){
			return new DiaPair(0, 0);
		}
		DiaPair left = diameter(root.left);
		DiaPair right = diameter(root.right);
		DiaPair current = new DiaPair(left.height + right.height + 1, Math.max(left.height, right.height) + 1);
		current.dia = Math.max(left.dia, Math.max(right.dia,current.dia));
		return current;
	}

	public static int height(BinaryTreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		int leftheight = height(root.left) + 1;
		int rightheight = height(root.right) + 1;
		if(leftheight > rightheight){
			return leftheight;
		}else{
			return rightheight;
		}
	}

	public static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int x){
		if(root == null){
			return null;
		}
		if(root.data == x){
			return root;
		}
		BinaryTreeNode<Integer> left = findNode(root.left, x);
		if(left != null){
			return left;
		}
		BinaryTreeNode<Integer> right = findNode(root.right, x);
		if(right != null){
			return right;
		}
		return null;
	}

	public static void inOrder(BinaryTreeNode<Integer> root){
		if(root == null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");			
		inOrder(root.right);
	}

	public static int sum(BinaryTreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		return root.data + sum(root.left) + sum(root.right); 
	}

	public static boolean checkIdentical(BinaryTreeNode<Integer> a, BinaryTreeNode<Integer> b){
		if(a == null && b == null){
			return true;
		}
		if(a == null || b == null){
			return false;
		}
		if(a.data == b.data){
			if(checkIdentical(a.left, b.left)){
				if(checkIdentical(a.right, b.right)){
					return true;
				}
			}				
		}
		return false;
	}

	// print element without siblings
	public static void elementWithoutSiblings(BinaryTreeNode<Integer> root){
		if(root.left == null && root.right == null){
			return;
		}
		if(root.left == null && root.right != null){
			System.out.println(root.right.data);
			elementWithoutSiblings(root.right);
		}else if(root.left != null && root.right == null){
			System.out.println(root.left.data);
			elementWithoutSiblings(root.left);
		}else{
			elementWithoutSiblings(root.right);
			elementWithoutSiblings(root.left);
		}
	}

	public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
		if(root == null){
			return null;
		}
		if(root.left == null && root.right == null){
			root = null;
		}
		if(root != null){
			root.left = removeLeaves(root.left);
			root.right = removeLeaves(root.right);
		}
		return root;
	}

	// 1 2 3 4 -1 5 6 -1 -1 -1 -1 -1 -1
	public static void levelwisePrint(BinaryTreeNode<Integer> root) throws EmptyQueue{
		QueueUsingLL<BinaryTreeNode<Integer>> primary = new QueueUsingLL<>();
		QueueUsingLL<BinaryTreeNode<Integer>> secondary = new QueueUsingLL<>();
		primary.enqueue(root);
		while(!primary.isEmpty()){
			while(!primary.isEmpty()){
				BinaryTreeNode<Integer> temp = primary.dequeue();
				System.out.print(temp.data);
				if(temp.left != null){
					secondary.enqueue(temp.left);
				}
				if(temp.right != null){
					secondary.enqueue(temp.right);
				}
			}
			System.out.println();
			primary = secondary;
			secondary = new QueueUsingLL<>();
		}		
	}

	//TODO how to do it without using LL.
	public static void zigZagPrint(BinaryTreeNode<Integer> root) throws EmptyQueue{
		LLnode<BinaryTreeNode<Integer>>[] tree = treeToLL(root);
		for(int i = 0; i < tree.length; i++){
			if(i % 2 == 1){
				tree[i] = reverseLL(tree[i]);
			}
			LLnode<BinaryTreeNode<Integer>> head = tree[i];
			while(head != null){
				System.out.print(head.data.data);
				head = head.next;
			}
			System.out.println();
		}
	}

	public static LLnode<BinaryTreeNode<Integer>> reverseLL(LLnode<BinaryTreeNode<Integer>> head){
		LLnode<BinaryTreeNode<Integer>> prev = head.next;
		LLnode<BinaryTreeNode<Integer>> current = prev;
		head.next = null;
		while(current != null){
			current = current.next;
			prev.next = head;
			head = prev;
			prev = current;			
		}
		return head;		
	}

	public static BinaryTreeNode<Integer> buildPreIn(int[] in, int[] pre, int inS, int inE, int preS, int preE){
		if(inS > inE){
			return null;
		}
		int rootdata = pre[preS];
		int i = inS;
		// Searching root in inorder
		while(i < inE){
			if(in[i] == rootdata){
				break;
			}
			i++;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
		int leftInS = inS;
		int leftInE = i - 1;
		int rightInS = i + 1;
		int rightInE = inE;

		int leftPreS = preS + 1;
		int leftInLen = leftInE - leftInS + 1;
		int leftPreE = leftPreS + leftInLen - 1;
		int rightPreS = leftPreE + 1;
		int rightPreE = preE;

		root.left = buildPreIn(in, pre, leftInS,leftInE,leftPreS,leftPreE);
		root.right = buildPreIn(in, pre, rightInS, rightInE,rightPreS,rightPreE);
		return root;

	}

	public static boolean checkBalanced(BinaryTreeNode<Integer> a, BinaryTreeNode<Integer> b){
		if(a == null || b == null){
			return true;
		}
		if(height(a) - height(b) == 1 || height(a) - height(b) == -1 || height(a) - height(b) == 0){
			if(checkBalanced(a.left, b.left)){
				if(checkBalanced(a.right, b.right)){
					return true;
				}
			}
		}
		return false;
	}

	public static void duplicateNodeLeft(BinaryTreeNode<Integer> root){
		if(root == null){
			return;
		}
		BinaryTreeNode<Integer> temp = root.left;
		BinaryTreeNode<Integer> duplicate = new BinaryTreeNode<Integer>(root.data);
		root.left = duplicate;
		duplicate.left = temp;
		duplicateNodeLeft(duplicate.left);
		duplicateNodeLeft(root.right);		
	}

	public static BinaryTreeNodePair nodesWithSum(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> currentNode, int sum) throws EmptyQueue{
		if(currentNode == null){
			return new BinaryTreeNodePair(null, null);
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pending = new QueueUsingLL<>();
		BinaryTreeNode<Integer> temp;
		pending.enqueue(root);
		while(!pending.isEmpty()){
			temp =  pending.dequeue();
			if(temp.data + currentNode.data == sum){
				return new BinaryTreeNodePair(currentNode, temp);
			}
			if(temp.left != null && temp.left != currentNode){ // so that i doesn't consider the same node twice
				pending.enqueue(temp.left);
			}
			if(temp.right != null && temp.right != currentNode){
				pending.enqueue(temp.right);
			}
		}
		if(nodesWithSum(root,currentNode.left, sum).first != null && nodesWithSum(root,currentNode.left, sum).second != null){
			return nodesWithSum(root,currentNode.left, sum);
		}
		return nodesWithSum(root,currentNode.right, sum);
	}

	public static BinaryTreeNode<Integer> lowestCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> a, BinaryTreeNode<Integer> b) throws EmptyQueue{
		if(root == null){
			return null;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pending = new QueueUsingLL<>();
		pending.enqueue(root);
		boolean flag1 = false, flag2 = false;
		while(!pending.isEmpty()){
			BinaryTreeNode<Integer> temp = pending.dequeue();
			if(temp.data == a.data){
				flag1 = true;
			}
			if(temp.data == b.data){
				flag2 = true;
			}
			if(flag1 == true && flag2 == true){
				break;
			}
			if(temp.left != null){
				pending.enqueue(temp.left);
			}
			if(temp.right != null){
				pending.enqueue(temp.right);
			}
		}
		if(lowestCommonAncestor(root.left, a, b) != null){
			return lowestCommonAncestor(root.left, a, b);
		}
		if(lowestCommonAncestor(root.right, a, b) != null){
			return lowestCommonAncestor(root.right, a, b);
		}
		if(flag1 == true && flag2 == true){
			return root;
		}
		return null;
	}

	public static void pathWithSum(BinaryTreeNode<Integer> root, int k, String str){
		if(root == null){
			return;
		}
		k -= root.data;
		str += root.data + " ";
		if(k == 0 && root.left == null && root.right == null){
			System.out.println(str);
			return;
		}
		if(k > 0){
			pathWithSum(root.left, k, str);
			pathWithSum(root.right, k, str);
		}else{
			return;
		}
	}

	public static LLnode<BinaryTreeNode<Integer>>[] treeToLL(BinaryTreeNode<Integer> root) throws EmptyQueue{
		LLnode<BinaryTreeNode<Integer>>[] tree = new LLnode[height(root)];
		for(int i = 0; i < height(root); i++){
			tree[i] = new LLnode<BinaryTreeNode<Integer>>();
		}
		QueueUsingLL<BinaryTreeNode<Integer>> current = new QueueUsingLL<>();
		current.enqueue(root);
		QueueUsingLL<BinaryTreeNode<Integer>> next = new QueueUsingLL<>();
		tree[0].data = root;
		int k = 1;
		while(!current.isEmpty()){
			while(!current.isEmpty()){	
				BinaryTreeNode<Integer> temp = current.dequeue();
				if(temp.left != null){
					next.enqueue(temp.left);
				}
				if(temp.right != null){
					next.enqueue(temp.right);
				}
			}
			if(!next.isEmpty()){
				BinaryTreeNode<Integer> temp = next.dequeue();
				tree[k].data = temp;
				LLnode<BinaryTreeNode<Integer>> head = tree[k];
				current.enqueue(temp);
				while(!next.isEmpty()){
					temp = next.dequeue();
					LLnode<BinaryTreeNode<Integer>> x = new LLnode<>(temp);
					head.next = x;
					head = head.next;
					current.enqueue(temp);
				}
			}
			k++;
		}
		return tree;
	}

	public static void main(String[] args) throws EmptyQueue {
		BinaryTreeNode<Integer> root = takeinput();
		//		BinaryTreeNode<Integer> a = new BinaryTreeNode<Integer>(3);
		//		BinaryTreeNode<Integer> b = new BinaryTreeNode<Integer>(4);
		//		BinaryTreeNode<Integer> b = takeinput();
		//		System.out.println(height(root));
		//		BinaryTreeNode<Integer> ans = findNode(root, 8);
		//		if(ans == null){
		//			System.out.println(ans);
		//		}else{
		//			System.out.println(ans.data);
		//		}
		//	}
		//		mirror(root);
		//		printLevelWise(root);
		//		System.out.println(diameter(root).dia);
		//		inOrder(root);
		//		System.out.println(sum(root));

		//		System.out.println(checkIdentical(root, b));
		//		elementWithoutSiblings(root);

		//		if(removeLeaves(root) != null){
		//			root = removeLeaves(root);
		//		}else{
		//			System.out.println("null");
		//		}
		//		printLevelWise(root);

		//		int pre[] = {1,2,4,5,3,6,7};
		//		int in[] = {4,2,5,1,6,3,7};
		//		BinaryTreeNode<Integer> root = buildPreIn(in, pre, 0, in.length - 1, 0, pre.length - 1);
		//		printLevelWise(root);

		//		zigZacPrint(root, 1);

		//		System.out.println(checkBalanced(root, b));

		//		duplicateNodeLeft(root);
		//		printLevelWise(root);

		//		int sum = 14;
		//		if(nodesWithSum(root,root, sum).first != null && nodesWithSum(root,root, sum).second != null){
		//			System.out.println(nodesWithSum(root,root, sum).first.data+" "+nodesWithSum(root,root, sum).second.data);
		//		}else{
		//			System.out.println("null null");
		//		}

		//		if(lowestCommonAncestor(root, a, b) != null){
		//			System.out.println(lowestCommonAncestor(root, a, b).data);
		//		}else{
		//			System.out.println("null");
		//		}

		//		LLnode<BinaryTreeNode<Integer>>[] ans = treeToLL(root);
		//		for(int i = 0; i < ans.length; i++){
		//			LLnode<BinaryTreeNode<Integer>> temp = ans[i]; 
		//			while(temp != null){
		//				System.out.print(temp.data.data);
		//				temp = temp.next;
		//			}
		//			System.out.println();
		//		}

		zigZagPrint(root);
	}
}
