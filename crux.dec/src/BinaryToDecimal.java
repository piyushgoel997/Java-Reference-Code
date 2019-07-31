import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a binary no.");
		int binary = s.nextInt();
		int decimal = 0, i = 0;
		while (binary > 0){
			decimal = (int) (decimal + (binary%10)*Math.pow(2, i));
			binary = binary/10;
			i++;			
		}
		System.out.println("the number in decimal is "+decimal);
		s.close();

	}

}
