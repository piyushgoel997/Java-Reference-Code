import java.util.Scanner;

public class Squareroot {


	public static double sqrt(int n, int decimal)
	{
		double i = 0;
		int j = 0;
		
		while(j <= decimal)
		{
			while(i*i <= n)
			{
				i =  (i + Math.pow(10,-j));
			}
			i = i - Math.pow(10,-j);
			
			j++;
		}
        return i;
	}



	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a no. and no. of decimal places ");
int n = s.nextInt();
int dec = s.nextInt();
double ans = sqrt(n,dec);
System.out.println("the ans is "+ans);


	}

}
