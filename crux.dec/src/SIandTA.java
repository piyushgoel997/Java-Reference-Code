import java.util.Scanner;

public class SIandTA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int principle,time;
		float rate,si,totalamount;
		Scanner s = new Scanner(System.in);
		System.out.println("enter principle amount");
		principle = s.nextInt();
		System.out.println("enter time");
		time = s.nextInt();
		System.out.println("enter rate");
		rate = s.nextFloat();
		si=(principle*rate*time)/100;
		System.out.println("the simple interest is "+si);
		totalamount = principle+si;
		System.out.println("the total amount is "+totalamount);
		s.close();
		
	}

}
