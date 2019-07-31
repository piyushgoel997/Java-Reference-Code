
public class AllPossibleCodes {


	public static void printallCodes(String input, String output)
	{
		// Base Case
		if(input.length() == 0)
		{
			System.out.println(output);
			return;
		}
		// General Case
		// a = 97
		// z = 122
		printallCodes(input.substring(1), output + (char)(input.charAt(0)-48 + 96));
		if(input.length() >= 2)
		{
			int x = 10*(input.charAt(0)-48) + input.charAt(1)-48 + 96;
			if(x <= 122 && x >= 97)
			{
				printallCodes(input.substring(2), output + (char)x);
			}
		}
	}
	
	
	public static void main(String[] args) {	
		printallCodes("1123", "");
		
	}

}
