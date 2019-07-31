import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("enter 2 numbers");
		int x = s.nextInt();
		int y = s.nextInt();             
		System.out.println("enter the operation to be done");
		char a = s.next().charAt(0);
		int ans;
		if (a==43){
			ans=x+y;
		}
		else if (a==45){
			ans=x-y;
		}
		else if (a==42){
			ans=x*y;
		}
		else if (a==47) {
			ans = x/y;
		}
		else {
			ans=x%y;
		}
		
		System.out.println(ans);    
        s.close();
	}

}
