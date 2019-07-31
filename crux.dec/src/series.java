import java.util.Scanner;

public class series {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a no.");
		int n = s.nextInt();
		int i=0,x;
		
		while (i<n){
			x = 3*(i+1)+2;
			if(x%4 != 0){
				System.out.print(x+" ");
			}
			i++;
		}
		
		
		
		s.close();

	}

}
