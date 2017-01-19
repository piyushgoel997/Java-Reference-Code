import java.util.Scanner;

public class MinMax {

	public static void main(String[] args) {
		int numberofIntergers;
		int i=0;
		Scanner s = new Scanner(System.in);
		System.out.println("enter the number of integers");
		numberofIntergers = s.nextInt();
		int max = Integer.MIN_VALUE;
		while (i<=numberofIntergers){
			System.out.println("Enter "+(i+1)+"number");
			int a;
			a = s.nextInt();
			if (a>max){
				max=a;
			}
			i++;
		}
		System.out.println("The Largest no. is "+max);
		s.close();
		

	}

}
