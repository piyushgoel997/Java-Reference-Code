import java.util.Scanner;

public class patternB {
	
	public static void main(String[] args){
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		n = s.nextInt();
		int row=0 , column;
		
		while (row<n){
			System.out.print(1);
			column=0;
			while(column<row-1){
				System.out.print("0");
				column++;
			}
			if (row>0){
				System.out.print(1);
			}
			row++;
			System.out.println();			
		}
		s.close();
	}	

}
