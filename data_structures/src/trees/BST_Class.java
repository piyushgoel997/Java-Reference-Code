package trees;

import stacksAndQueues.node;

public class BST_Class<T extends Comparable<T>> {
	private BinaryTreeNode<T> root;
	private int size;

	public BST_Class() {
		root = new BinaryTreeNode<>();
		size = 0;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public BinaryTreeNode<T> search(T element){
		BinaryTreeNode<T> temp = root;
		while(temp != null){
			if(element.equals(root.data)){
				return root;
			}else if(element.compareTo(root.data) == 1){
				if(root.right != null){
					temp = temp.right;
				}
			}else{
				if(root.left != null){
					temp = temp.left;
				}
			}
		}
		return null;		
	}

	public T remove(T element){
		BinaryTreeNode<T> temp = search(element);
		T ans = temp.data;
//		BinaryTreeNode<T> prev = null;
//		// Searching element and keeping prev
//		while(temp != null){
//			if(element.equals(root.data)){
//				break;
//			}else if(element.compareTo(root.data) == 1){
//				if(root.right != null){
//					prev = temp;
//					temp = temp.right;
//				}
//			}else{
//				if(root.left != null){
//					prev = temp;
//					temp = temp.left;
//				}
//			}
//		}
		BinaryTreeNode<T> prev = new BinaryTreeNode<>();
		BinaryTreeNode<T> current = temp;
		while(current.left != null){
			prev = current;
			current = current.left;
		}
		temp.data = current.data;
		if(current.right == null){
			current = null;
		}else{
			prev.left = current.right;
		}
		return ans;
	}
	
	//TODO insert
	

}
