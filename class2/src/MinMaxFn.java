import java.util.Scanner;

public class MinMaxFn {
	
	public static int Max(){
		
		int i=0,a;
		Scanner s = new Scanner(System.in);
		System.out.println("enter the number of integers");
		int numberofIntergers = s.nextInt();
		int max = Integer.MIN_VALUE;
		while (i<numberofIntergers){
			System.out.println("Enter "+(i+1)+" number");
			a = s.nextInt();
			if (a>max){
				max=a;
			}
			i++;
		}
		return max;
		
	}
	
public static int Min(){
		
		int i=0,a;
		Scanner s = new Scanner(System.in);
		System.out.println("enter the number of integers");
		int numberofIntergers = s.nextInt();
		int min = Integer.MAX_VALUE;
		while (i<numberofIntergers){
			System.out.println("Enter "+(i+1)+" number");
			a = s.nextInt();
			if (a<min){
				min=a;
			}
			i++;
		}
		return min;
		
	}
	
	
	
	public static void main(String[] args) {
				
		int max = Max();
		System.out.println("The Largest no. is "+max);
		
	}

}
