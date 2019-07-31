import java.util.Scanner;

public class Strings 
{

	//	Doesn't remove repetetion in the last letter like in dd of aabbbcdd but it would remove it if 
	//	a non repeating letter is present at last 
	public static char[] removeduplicate(char[] string)
	{
		int newlength = string.length;
		int i = 0;
		while( i < newlength -1)
		{
			for(int j = 1; j < newlength ; j++)
			{

				if(string[i] != string[i+j])
				{
					for(int k = 0; k < newlength -i -j; k++ )
					{
						string[i+k+1] = string[i+j+k];
					}
					newlength = newlength -j +1;
					break;
				}

			}
			i++;
		}
		char[] newstring = new char[newlength];
		for(int j = 0; j < newlength; j++)
		{
			newstring[j] = string[j];
		}
		return newstring;
	}


	public static int noofwords(String str)
	{
		int count = 1;
		char[] strarr = str.toCharArray();
		for(int i =0; i < str.length(); i++)
		{	
			if(strarr[i] == '$')
			{
				return count;
			}
			if(strarr[i] == ' ')
			{
				count++;
			}
		}
		return count;
	}


	public static int noofchars(String str)
	{
		int count = 0;
		char[] strarr = str.toCharArray();
		for(int i =0; i < str.length(); i++)
		{		
			if(strarr[i] == '$')
			{
				return count;
			}
			if(strarr[i] != ' ' || strarr[i] != '.')
			{
				count++;
			}
		}
		return count;
	}


	public static int nooflines(String str)
	{
		int count = 0;
		char[] strarr = str.toCharArray();
		for(int i =0; i < str.length(); i++)
		{			
			if(strarr[i] == '$')
			{
				return count;
			}
			if(strarr[i] == '.')
			{
				count++;
			}
		}
		return count;
	}


	public static void removeduplicate2(char[] string)
	{
		int newlength = string.length;
		int i = 0;
		while( i < newlength -1)
		{
			for(int j = 1; j < newlength ; j++)
			{

				if(string[i] != string[i+j] )
				{
					System.out.print(string[i+j-1]);
					for(int k = 0; k < newlength -i -j; k++ )
					{
						string[i+k+1] = string[i+j+k];
					}
					newlength = newlength -j +1;

					if(j !=1)
					{
						System.out.print(j);
					}
					break;
				}

			}
			i++;
		}

	}

	// isn't able to consider last word.
	// unable to return the word.
	public static void smallestword(String str)
	{

		int min = str.length();

		char[] strarr = str.toCharArray();
		for(int i =0; i < str.length() -1; i = i)
		{	
			int count = 0;
			for(int j = i; strarr[j] != ' ' || strarr[j] == '.'; j++)
			{
				count++;

			}
			if(count < min)
			{
				min = count;
				System.out.println(min);
			}
			i = i +count+1;
		}
		System.out.println(min);


	}


	public static char highestoccuring(String str)
	{
		int count = 0;
		int maxct = 0;
		char max = '?';
		char[] strarr = str.toCharArray();
		for(int i =0; i < str.length(); i++)
		{		
			count = 0;
			for(int j = i+1; j < str.length(); j++)
			{
				if(strarr[i] == strarr[j])
				{
					count++;
				}
			}
			if(count > maxct)
			{
				maxct = count;
				max = strarr[i];
			}
		}

		return max;

	}


    public static void substrings(String str)
    {
    	for(int i = 0; i < str.length(); i++)
    	{
    		for(int j = i + 1; j < str.length()+1; j++)
    		{
    			System.out.println(str.substring(i, j));
    		}
    		
    	}
    	
    }
    
    


	public static void printarray(char[] arr)
	{
		for(int i=0; i<arr.length ; i++)
		{
			System.out.print(arr[i]);
		}
	}

	

	public static void main(String[] args) 
	{
		// Remove consecutive duplicate chars
		/*Scanner s = new Scanner(System.in);
		System.out.println("enter the string");
		String str = s.next();
		char[] string = removeduplicate(str.toCharArray());
		System.out.println("the resultant string is ");
		printarray(string);
		 */

		// No. of words,chars,lines.
		// Didn't know how to take multiple line input.
		/*Scanner s = new Scanner(System.in);
		System.out.println("enter the string");
		String str = s.nextLine();
		int words = noofwords(str), chars = noofchars(str), lines = nooflines(str);
		System.out.println(words);
		System.out.println(chars);
		System.out.println(lines);*/

		// Remove duplicate and print nos.
		// doesn't print the last set of chars 
		/*Scanner s = new Scanner(System.in);
		System.out.println("enter the string");
		String str = s.next();
		removeduplicate2(str.toCharArray());
		 */



		// Shortest word
		/*Scanner s = new Scanner(System.in);
		System.out.println("enter the string");
		String str = s.nextLine();
		smallestword(str);*/


		// Highest occuring char
		/*Scanner s = new Scanner(System.in);
		System.out.println("enter the string");
		String str = s.next();
		char max = highestoccuring(str);
		System.out.println("the char occuring max no. of times is "+max);
		*/
		
		String str = "abcde";
		substrings(str);
	}

}
