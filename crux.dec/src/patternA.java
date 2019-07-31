import java.util.Scanner;

public class patternA {
	
	public static void main(String[] args){
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		n = s.nextInt();
		int row=0 , column=0;
		
		while (row<n){
			column=0;
			while(column<=row){
				System.out.print("1");
				column++;
			}
			row++;
			System.out.println();			
		}
    	s.close();
	}
		
}
