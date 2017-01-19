import java.util.Scanner;

public class SeparateOddEvenSum {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter a no.");
		int number = s.nextInt();
		int x = number;
		//odd
		int y,odd=0;
		y = (int) (x%(Math.pow(10, 1)));
		odd=y;
		while (x>0){
			x = x/100;
			y = x%10;
			odd = odd + y;
		}
		System.out.println("sum of odd terms is "+odd);
		//even
		y=0;
		int even = 0;
		x = number/10;
		while (x>0){			
			y = x%10;
			even = even + y;
			x = x/100;
		}
		System.out.println("sum of odd terms is "+even);



	}

}
