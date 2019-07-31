
public class ABString {
	
	public static boolean checkABString(String input)
	{
		if(input.startsWith("a"))
			return checkABString_helper(input);
		else
			return false;
	}

	public static boolean checkABString_helper(String input)
	{
		// Base cases
		if(input.length() == 0)
		{
			return true;
		}
		if(input.length() == 1)
		{
			if(input.charAt(0) == 'a')
				return true;
		}
		if(input.length() == 2)
		{
			if(input.startsWith("bb"))
				return true;
		}

		// General case
		if(checkABString(input.substring(1)))
		{
			if(input.charAt(0) == 'a')
			{
//				if(!(input.charAt(1) == 'a' || input.substring(1, 3) == "bb"))
//					return false;
				if(!(input.substring(1).startsWith("a") || input.substring(1).startsWith("bb")))
					return false;				
			}
			if(input.substring(0, 2) == "bb")
			{
				if(input.charAt(2) != 'a')
					return false;				
			}
		}
		else return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkABString("abb"));
	}

}
