import java.util.Scanner;

public class pattern2 {
	public static void main(String[] args){
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		n = s.nextInt();
		int row=1 , value=1, column=1;
		while(row<=n){
			value=row;
			column=1;
			while(column<=n-row){
				System.out.print(" ");
				column++;
			}
			column=1;
			while (column<=row){
				System.out.print(value);
				value++;
				column++;
			}
			column=1;
			value-=2;
			while(column<row){
				System.out.print(value);
				value--;
				column++;				
			}	
			row++;
			System.out.println();
		}
		s.close();
	}	
}
	
