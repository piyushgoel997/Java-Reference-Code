import java.util.Scanner;

public class SqrtIntOnly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a no.");
		int x = s.nextInt();
		int sqrt = (int) Math.sqrt(x);
		System.out.println("the square root fo the given no. is "+sqrt);
        s.close();
	}

}
