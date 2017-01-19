import java.util.Scanner;

public class DecToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		System.out.println("Enter a decimal no.");
		int decimal = s.nextInt();
		int binary = 0, i, x, n;
		
				
		while (decimal > 0){
			i=0;
			x = decimal;
			while (x >0){
				x = x/2;
				i++;
				System.out.println(x);
			}
			n=i-1;
			binary = (int) (binary +Math.pow(10, n));
			decimal = (int) (decimal%Math.pow(2, n));
		}
		System.out.println("the number in binary is "+binary);
		s.close();        
	}

}
