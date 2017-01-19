
public class Ques {

	public static int factorial(int num)
	{
		if(num <= 1)
		{
			return 1;
		}

		return num*factorial(num-1);
	}

	public static int noOfZeroesinFact(int num)
	{
		int x = factorial(num);
		int count = 0;
		while(x > 0)
		{
			if(x%10 == 0)
				count++;
			x = x/10;
		}
		return count;
	}

	public static int zeroes(int num)
	{
		int count = 0;
		while(num%5 != 0)
			num--;
		while(num > 4)
		{
			int x = num;
			while(x > 4)
			{
				if(x%5 == 0)
					count++;
				x = x/5;
			}			
			num = num - 5;
		}
		return count;
	}

//	public static int factZero(int num)
//	{
//		int count = 0;
//		if(num%10 < 5)
//		{
//			while(num%5 != 0)
//				num--;
//			
//		}
//		if(num%10 >= 5)
//		{
//			while(num%5 != 0)
//			{
//				num++;
//			}
//		}
//		num = num/2;
//		while(num > 0)
//		{
//			num = num - 5;
//			count++;				
//		}
//		return 2*count;
//	}

	public static int palindromeSubstrings(String input)
	{
		int count = 0;
		for(int i = 0; i < input.length(); i++ )
		{
			for(int j = 0; i-j >= 0 && i+j < input.length(); j++)
			{
				if(input.charAt(i-j) == input.charAt(i+j))
				{
					count++;
				}
				else 
					break;
			}
			for(int j = 0; i-j >= 0 && i+j+1 < input.length(); j++)
			{
				if(input.charAt(i-j) == input.charAt(i+j+1))
				{
					count++;
				}
				else
					break;
			}
		}
		return count;
	}




	public static void main(String[] args) {

	//	System.out.println(zeroes(16));
	//	System.out.println(factZero(16));
		System.out.println(palindromeSubstrings("abcadaa"));
	}

}
