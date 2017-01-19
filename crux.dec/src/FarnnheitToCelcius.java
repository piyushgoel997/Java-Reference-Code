import java.util.Scanner;

public class FarnnheitToCelcius {

	public static void main(String[] args) {
		/*	int farenheitValue = 62;
		int celsiusValue;
		celsiusValue = (int)((5.0/9)*(farenheitValue - 32));
		System.out.println(celsiusValue);
		System.out.println(1+2);
		System.out.println(1.0+2);  */
		/*	char a = 'a';
		char b ='b';
		char c = (char)(a+b);
		System.out.println(a+b);
		System.out.println(c);
		System.out.println("Hello"+10);  */

		/*	int a;
		int b =a++;
		System.out.println(a+" "+b);   */

		int currentFarenheitValue=0; 
		int maxFarenheitValue, minFarenheitValue;
		
		Scanner console = new Scanner(System.in);
		System.out.println("Enter Min Farenheit Value");
		minFarenheitValue = console.nextInt();
		System.out.println("Enter Max Farenheit Value");
		maxFarenheitValue = console.nextInt();
	    currentFarenheitValue = minFarenheitValue;
		int celsiusValue;
		while(currentFarenheitValue<=maxFarenheitValue){
			celsiusValue = (int)((5.0/9)*(currentFarenheitValue-32));
			System.out.println(currentFarenheitValue+" "+celsiusValue);
			currentFarenheitValue += 20;
		}
		console.close();
	}
}
