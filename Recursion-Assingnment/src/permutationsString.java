
public class permutationsString {


	public static String[] permutations(String input)
	{
		if(input.length() == 1)
		{
			String[] str = {input}; 
			return str;
		}
		String[] str = permutations(input.substring(1));
		String[] output = new String[factorial(input.length())];
		int k = 0;
		for(int i = 0; i < str.length; i++)
		{
			for(int j = 0; j <= str[i].length(); j++)
			{
				output[k] = str[i].substring(0, j) + input.charAt(0) + str[i].substring(j);
				k++;
			}			
		}
		return output;
	}


	public static void printPermutations(String input, String output)
	{
		if(input.length() == 0)
		{
			System.out.println(output);
			return;
		}
		for(int j = 0; j <= output.length(); j++)
		{
			printPermutations(input.substring(1), output.substring(0, j) + input.charAt(0) + output.substring(j));
		}
	}


	public static String[] permutations2(String input)
	{
		if(input.length() == 0)
		{
			String[] str = {""}; 
			return str;
		}
		String[] output = new String[factorial(input.length())];
		int k =0;
		for(int i = 0; i < input.length(); i++)
		{
			String[] str = permutations(input.substring(0,i) + input.substring(i+1));			
			for(int j = 0; j < str.length; j++)
			{
					output[k] = input.charAt(i) + str[j];
					k++;
			}
		}
		return output;
	}


	public static int factorial(int num)
	{
		if(num <= 1)
		{
			return 1;
		}

		return num*factorial(num-1);
	}


	public static void main(String[] args) {

		String str[] = permutations2("abc");
		for(int i = 0; i < str.length; i++)
		{
			System.out.println(str[i]);
		}
		//		printPermutations("abc", "");
	}

}
