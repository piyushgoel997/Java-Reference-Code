import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=2 , n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number");
		n = s.nextInt();
		while (i<n){
			if(n%i==0){
				System.out.println("the number is not prime");
				//return;
				break;
			}
			i++;
		}
		if(i==n){
			System.out.println("the number is prime");

		}
		s.close();


	}
}