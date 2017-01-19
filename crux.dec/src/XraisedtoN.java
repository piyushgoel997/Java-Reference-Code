import java.util.Scanner;

public class XraisedtoN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("enter x and n");
		int x = s.nextInt();
		int n = s.nextInt();
		int i=0;
		int ans=1;
		while (i<n){
			ans=ans*x;
			i++;
		}
		System.out.println(x+" raised to the power "+n+" is "+ans);
		s.close();

	}

}
