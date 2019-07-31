import java.util.Scanner;

public class UpperOrLower {
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("enter a alphabet");
		char a = s.next().charAt(0);
		if (a>=97 && a<=122){
			System.out.println("You entered a lower case alphabet");
		}
		else if (a>=65 && a<=90){
			System.out.println("You entered a upper case alphabet");
		}
		else {
			System.out.println("Invalid Input");
		}
			
		s.close();
	}
	
}
