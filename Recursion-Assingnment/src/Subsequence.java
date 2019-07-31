
public class Subsequence {
	
	public static String[] subsequence(String str)
	{
		if(str.length() <= 0)
		{
			String[] s = {""};
			return s;
		}
		
		String[] s = subsequence(str.substring(1));
		String[] output = new String[s.length*2];
		int k = 0;
		for(int i = 0; i < s.length; i++)
		{
			output[k] = s[i];
			k++;
		}
		for(int i = 0; i < s.length; i++)
		{
			output[k] = str.charAt(0) + s[i];
			k++;
		}
		return output;
	}
	
	public static void printSubsequence(String input, String output){
		if(input.length() == 0){
			System.out.println(output);
			return;
		}

		printSubsequence(input.substring(1), output);
		printSubsequence(input.substring(1), output + input.charAt(0));


	}

	public static void main(String[] args) {
		
//		printSubsequence("adc", "");
		String[] str = subsequence("abc");
		for(int i = 0; i < str.length; i++)
		{
			System.out.println(str[i]);
		}
	}

}
