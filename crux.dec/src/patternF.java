import java.util.Scanner;

public class patternF {
	
	public static void main(String[] args){
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		n = s.nextInt();
		int row=0 , column;
		
		while (row<n){
			column=0;
			while(column<=row){
				System.out.print((n-row));
				column++;
				
			}
			row++;
			System.out.println();
			
		}
		
		s.close();
		
	}

}
