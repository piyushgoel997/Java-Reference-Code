package Heaps;

import java.util.ArrayList;

public class HeapUse {
	
	// O(n(log(k)))
	public static void sortK(int[] arr, int k){
		MinHeap<Integer> pq = new MinHeap<>();
		for(int i = 0; i < k; i++){
			pq.insert(arr[i], arr[i]);
		}
		for(int i = 0; i < arr.length; i++){
			arr[i] = pq.removeMin();
			if(i + 3 < arr.length){
				pq.insert(arr[i+3], arr[i+3]);
			}
		}
	}
	
	// O(n(log(k)))
	public static int[] largestKElements(int[] arr, int k){
		MinHeap<Integer> pq = new MinHeap<>();
		for(int i = 0; i < k; i++){
			pq.insert(arr[i], arr[i]);
		}
		for(int i = k; i < arr.length; i++){
			pq.insert(arr[i], arr[i]);
			pq.removeMin();
		}
		int output[] = new int[k];
		for(int i = 0; i < k; i++){
			output[k - i] = pq.removeMin();
		}
		return output;
	}
	
	public static ArrayList<Integer> mergeArrayLists(ArrayList<Integer>[] input){
		MinHeap<Integer> pq = new MinHeap<>();
		int k = 0;
		for(ArrayList<Integer> i : input){
			for(Integer j : i){
				pq.insert(j, k);
				k++;
			}
		}
		ArrayList<Integer> output = new ArrayList<>();
		while(!pq.isEmpty()){
			output.add(pq.removeMin());
		}
		return output;
	}
	
	public static void main(String[] args) {
//		int[] arr = {2,5,1,3,9,6,7};
//		int k = 3;
//		sortK(arr, k);
//		for(int i : arr){
//			System.out.println(i);
//		}
		
//		int[] arr = {2,5,1,3,9,6,7};
//		int k = 3;
//		int[] output = largestKElements(arr, k);
//		for(int i : output){
//			System.out.println(i);
//		}
		
		ArrayList<Integer>[] input = new ArrayList[3];
		input[0] = new ArrayList<>();
		input[1] = new ArrayList<>();
		input[2] = new ArrayList<>();
		input[0].add(1);
		input[2].add(2);
		input[0].add(5);
		input[1].add(3);
		ArrayList<Integer> output = mergeArrayLists(input);
		for(int i : output){
			System.out.println(i);
		}
		
	}

}
