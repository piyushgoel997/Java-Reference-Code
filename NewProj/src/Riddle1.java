import java.util.Scanner;

public class Riddle1 {
	
	// Dec to Binary
	public static double decToBin(double dec)
	{
		if(dec == 0)
		{
			return 0;
		}
		double binary;
		int x = (int) dec;
		int ctr = 0;
		while(x > 0)
		{
			x = x/2;
			ctr++;
		}
		binary = (Math.pow(10, ctr-1) + decToBin(dec%Math.pow(2, ctr-1)));
		return binary;
	}
	
	// Reverse an int
	public static int reverseint(int num)
	{
		if(num == 0)
		{
			return 0;
		}
		int reversed = 0;
		int ctr = 0, x = num;
		while(x > 0)
		{
			x = x/10;
			ctr++;
		}
		reversed = (int) ((num%10)*Math.pow(10, ctr-1) + reverseint(num/10));
		return reversed;
	}
	
	// Binary to Dec
	public static int binToDec(int bin)
	{
		if(bin == 0)
		{
			return 0;
		}
		int dec = 0;
		dec = (bin%10) + 2*(binToDec(bin/10));
		return dec;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int arr[] = new int[10];
		Scanner s = new Scanner(System.in);
		while(true)
		{
			arr[i] = s.nextInt();
			if(arr[i] == -1)
				break;
			i++;
			
		}
		i = i - 1;
		for(int j = 0; j <= i; j++)
		{
			int x = (int) decToBin(arr[j]);
			int y = reverseint(x);
			System.out.println(binToDec(y));
		}
	}

}
