import java.util.Scanner;

public class SqrtN {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a no.");
		float x = s.nextFloat();
		float sqrt = (float) Math.sqrt(x);
		System.out.println("the square root fo the given no. is "+sqrt);
        s.close();
	}

}
