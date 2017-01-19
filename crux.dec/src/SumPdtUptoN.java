import java.util.Scanner;

public class SumPdtUptoN {
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = s.nextInt();
		System.out.println("press 1 if you want sum of first n natural nos. and 2 for their product");
		int x = s.nextInt();
		int ans;
		if (x==1){
			ans = n*(n+1)/2;
			System.out.println("sun of first n natural numbers is "+ans);
		}
		else if (x==2){
			int i=1;
			ans=1;
			while (i <= n){
				ans=ans*i;
				i++;
			}
			System.out.println("the product of first n natural numbers is "+ans);
		}
		else{
			System.out.println("please either press 1 or 2");
		}
		
		s.close();
		
	}

}
