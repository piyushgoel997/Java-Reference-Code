import java.util.Scanner;

public class BearAndGame {
	
	public static int offTime(int[] arr) {
		if(arr[0]>15){
			return 15;
		}
		for(int i = 0 ; i< arr.length-1;i++){
			if(arr[i+1]-arr[i]>15){
				return arr[i] + 15;
			}
		}
		if(arr[arr.length-1]+15 <= 90) {
			return arr[arr.length-1]+15;
		}
		return 90;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int[] arr = new int[t];
		for(int i = 0; i < t; i++){
			arr[i] = s.nextInt();
		}
		System.out.println(offTime(arr));
	}

}
