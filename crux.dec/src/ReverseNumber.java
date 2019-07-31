import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the no. to be reversed");
		int n = s.nextInt();
		int rev = 0 ;
		while (n>0){
			rev = (rev + n%10)*10;
			n = n/10;
		}
		rev = rev/10;
		System.out.println("the reversed number is"+rev);
		s.close();
	}

}
