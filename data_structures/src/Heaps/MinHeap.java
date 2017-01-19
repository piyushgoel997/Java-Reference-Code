package Heaps;

import java.util.ArrayList;

public class MinHeap<V> {
	private ArrayList<PQPair<V>> heap;
	
	public MinHeap(){
		heap = new ArrayList<>();
	}
	
	public int size(){
		return heap.size();
	}
	
	public boolean isEmpty(){
		return heap.size() == 0;
	}
	
	public void insert(V value, int priority){
		PQPair<V> child = new PQPair(value, priority);
		heap.add(child);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1)/2;
		PQPair<V> parent = heap.get(parentIndex);
		// Heapify
		while(childIndex > 0){
			if(child.priority < parent.priority){
				heap.set(parentIndex, child);
				heap.set(childIndex, parent);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1)/2;
				parent = heap.get(parentIndex);
			}else{
				return;
			}
		}
	}
	
	public V removeMin(){
		V temp = heap.get(0).value;
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		int leftChildIndex = 1;
		int rightChildIndex = 2;
		int minIndex = 0;
		while(leftChildIndex < heap.size()){
			int index = minIndex;
			if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority){
				minIndex = leftChildIndex;
			}
			if(rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority){
				minIndex = rightChildIndex;
			}
			if(minIndex != index){
				PQPair<V> pair = heap.get(minIndex);
				heap.set(minIndex, heap.get(index));
				heap.set(index, pair);
				leftChildIndex = 2*index + 1;
				rightChildIndex = 2*index + 2;
			}else{
				break;
			}
		}
		return temp;
	}
	
	
}
