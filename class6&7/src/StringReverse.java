
public class StringReverse {


	public static String stringreverse(String str)
	{
		int i;
		for(i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == ' ')
			{
				break;
			}
		}
		if(i < str.length())
		{
			String s = stringreverse(str.substring(i+1));
			return s + str.substring(0,i+1);	

		}
		else return str + " ";
	}

	public static void main(String[] args) {
		String str = "Welcome to coding blocks";
		String str2 = stringreverse(str);
		System.out.println(str2);
	}

}
