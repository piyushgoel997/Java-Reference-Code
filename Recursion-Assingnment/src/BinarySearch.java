
public class BinarySearch {

	public static String[] subsequence(String str)
	{
		if(str.length() == 0)
		{
			String[] s = {""};
			return s;
		}
		
		String s[] = subsequence(str.substring(1));
		String output[] = new String[2*s.length];
		for(int i = 0; i < s.length; i++)
		{
			output[i] = s[i];
		}
		for(int i = 0; i < s.length; i++)
		{
			output[i+s.length] = str.charAt(0) + s[i];
		}
		return output;
				
	}

	public static int binarysearch(int[] arr, int num, int beginindex, int endindex)
	{
		if(endindex < beginindex)
		{
			return -1;
		}
		int n = (endindex+beginindex+1)/2;
		if(num < arr[n])
		{
			endindex = n-1;
		}
		if(num > arr[n])
		{
			beginindex = n+1;
		}
		if(num == arr[n])
		{
			return n;
		}
		return binarysearch(arr, num, beginindex, endindex);
	}

	public static void main(String[] args) 
	{

		int arr[] = {1,2,3,4,5,6,7,8,9};
		System.out.println(binarysearch(arr, 9, 0, 8));

		String x[] = subsequence("abcd");
		for(int i = 0; i < x.length; i++)
		{
			System.out.println(x[i]);
		}
	}
}
