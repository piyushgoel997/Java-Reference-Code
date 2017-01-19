package spoj;

import java.util.Scanner;

public class ADDREV {
	
	public static int reverseInteger(int n){
		int temp = n;
		int size = 0;
		while(temp != 0){
			size++;
			temp = temp/10;
		}
		temp = n;
		int result = 0;
		for(int i = 0; i < size; i++) {
			result += (temp%10)*Math.pow(10, size -i -1);
			temp /= 10;
		}
		return result;
	}
	
	public static int addIntegers(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int[] arr = new int[t];
		for(int i = 0; i < t; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			arr[i] = reverseInteger(addIntegers(reverseInteger(a),reverseInteger(b)));
		}
		for(int i = 0; i < t; i++) {
			System.out.println(arr[i]);
		}
		s.close();
	}

}
