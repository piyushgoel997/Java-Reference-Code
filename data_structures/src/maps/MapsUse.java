package maps;

import java.util.*;

public class MapsUse {

	public static void pairSum(int[] arr, int k){
		Hashtable<Integer,Integer> map = new Hashtable<>();
		for(int i : arr){
			//			if(!map.containsKey(i)){
			map.put(i, 1);
			//			}else{
			//				map.put(i, map.get(i) + 1);
			//			}
		}
		for(int i : arr){
			if(map.containsKey(k - i)){
				System.out.println(i+","+(k - i));
				//				map.put(k - i, map.get(k - i) - 1);
				//				map.put(i, map.get(i) - 1);
			}
		}
	}

	public static String extractUniqueChars(String input){
		Hashtable<Character, Character> map = new Hashtable<>();
		for(int i = 0; i < input.length(); i++){
			if(!map.containsKey(input.charAt(i))){
				map.put(input.charAt(i), input.charAt(i));
			}
		}
		String output = "";
		for(int i = 0; i < input.length(); i++){
			if(map.containsKey(input.charAt(i))){
				output += map.remove(input.charAt(i));
			}
		}
		return output;
	}

	public static void main(String[] args) {
//		Hashtable<Integer, Integer> map = new Hashtable<>();
//		int arr[] = {-2,-2,2};
//
//		for(int i : arr){
//			//			if(!map.containsKey(i)){
//			map.put(i, 1);
//			//			}
//		}

		//		int output[] = new int[map.size()];
		//		int k = 0;
		//		for(int i : arr){
		//			if(map.containsKey(i) && map.get(i) == 1){
		//				map.put(i, 0);
		//				output[k] = i;
		//				k++;
		//			}
		//		}
		//		for(int i : output){
		//			System.out.println(i);
		//		}

		//		pairSum(arr, 0);
		
		
		String input = "axabcdacbd";
//		System.out.println(extractUniqueChars(input));
		

	}

}
