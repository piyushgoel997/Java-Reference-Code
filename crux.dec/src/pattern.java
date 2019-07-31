import java.util.Scanner;

public class pattern {
	
	public static void main(String[] args){
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		n = s.nextInt();
		int row=1 , column=1, value=1;
		while (row<=n){
			column=1;
			while (column<=row){
				System.out.print(value);
				value++;
				column++;
			}
			System.out.println();
			row++;
			
		}
		s.close();
		
	}

}
