
public class keypad 
{




	public static String[] keypadx(int num)
	{
		if(num == 0)
		{
			String[] str = {""};
			return str;
		}
		int x = num%10;
		String str = keypad_helper(x);
		//		String curr[] = new String[str.length()];
		//		for(int i = 0; i < curr.length; i++)
		//		{
		//			curr[i] = str.charAt(i) + "";
		//		}
		String prev[] = keypadx(num/10);
		//		String[] output = new String[prev.length*curr.length];
		String[] output = new String[prev.length*str.length()];

		int k = 0;
		for(int i = 0; i < prev.length; i++)
		{
			//			for(int j = 0; j < curr.length; j++)
			//			{
			//				output[k] = prev[i] + curr[j];
			//				k++;
			//			}
			for(int j = 0; j < str.length(); j++)
			{
				output[k] = prev[i] + str.charAt(j);
				k++;
			}
		}
		return output;
	}

	public static String keypad_helper(int num)
	{
		switch(num)
		{
		case 2:
			return "abc";
		case 3:
			return "def";
		case 4:
			return "ghi";
		case 5:
			return "jkl";
		case 6:
			return "mno";
		case 7:
			return "pqrs";
		case 8:
			return "tuv";
		case 9:
			return "wxyz";
		default:
			return "";
		}	
	}

	public static void printKeypad(int num, String output)
	{

		if(num == 0)
		{
			System.out.println(output);
			return;
		}
		String str = keypad_helper(num%10);
		printKeypad(num/10, str.charAt(0) + output);
		printKeypad(num/10, str.charAt(1) + output);
		printKeypad(num/10, str.charAt(2) + output);
		if(str.length() >= 4)
		{
			printKeypad(num/10, str.charAt(3) + output);

		}
	}

	// Time,Space Complexity = n
	public static String revKeypad(String input,String[] keyHelp){
		if(input.length() == 0){
			return "";
		}
		int current = (int)input.charAt(0);
		int i = 2;
		while(i < keyHelp.length){
			if(current >= (int)keyHelp[i].charAt(0)){
				i++;
			}else{ 
				break;
			}
		}
		i -= 1;
		// 2nd part
		int j = 0;
		while(j < keyHelp[i].length()){
			if(current == keyHelp[i].charAt(j))
				break;
			else
				j++;
		}
		int temp = i;
		for(int k = 0; k < j; k++)
		{
			i = 10*i;
			i = i + temp;
		}
		return i + " " + revKeypad(input.substring(1), keyHelp);
	}



	public static void main(String[] args)
	{
		//		String[] str = keypadx(27);
		//		for(int i = 0; i < str.length; i++)
		//		{
		//			System.out.println(str[i]);
		//		}
		//		printKeypad(273,"");

		String[] keyHelp = new String[10];
		keyHelp[2] = "abc";
		keyHelp[3] = "def";
		keyHelp[4] = "ghi";
		keyHelp[5] = "jkl";
		keyHelp[6] = "mno";
		keyHelp[7] = "pqrs";
		keyHelp[8] = "tuv";
		keyHelp[9] = "wxyz";

		System.out.println(revKeypad("adez", keyHelp));

	}

}
