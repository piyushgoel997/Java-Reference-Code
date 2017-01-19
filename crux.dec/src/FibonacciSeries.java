import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int x=1,first=1,second=0;
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a Number");
		n = s.nextInt();
		System.out.println(0);
		while(x<=n){
			System.out.println(x);
			x=first+second;
			second=first;
			first=x;	
			
		}
		s.close();
		
	}

}
