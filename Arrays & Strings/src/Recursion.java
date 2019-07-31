
public class Recursion {

	public static void printarray(int[] arr)
	{
		for(int i=0; i<arr.length ; i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

	public static int power(int base, int exp)
	{
		if(exp == 0)
		{
			return 1;
		}
		int e = exp - 1;
		int ans = base*power(base,e);
		return ans;		
	}

	public static boolean check7(int[] arr, int startindex)
	{
		if(startindex >= arr.length)
		{
			return false;
		}
		boolean nextcheck = check7(arr,startindex +1);
		if(!nextcheck)
		{
			if(arr[startindex] == 7)
			{
				return true;
			}
			else return false;

		}
		return check7(arr,startindex +1);

	}

	public static int firstindexof7(int[] arr)
	{
		if(arr.length == 0)
		{
			return 1;
		}
		int[] newarr = new int[arr.length-1];
		for(int i = 0; i < newarr.length; i++)
		{
			newarr[i] = arr[i+1];
		}
		if(arr[0] == 7)
		{
			return 0;
		}
		else
		{
			return 1+firstindexof7(newarr);
		}

	}
	
	public static int firstindexof7wi(int[] arr,int startindex)
	{
		if(startindex == arr.length)
		{
			return 0;
		}

		if(arr[startindex] == 7)
		{
			return startindex;	
		}
		else
		{
			return firstindexof7wi(arr,startindex+1);
		}

	}

	public static int lastindexof7(int[] arr)
	{
		if(arr.length == 0)
		{
			return 1;
		}
		int[] newarr = new int[arr.length-1];
		for(int i = 0; i < newarr.length ; i++)
		{
			newarr[i] = arr[i];
		}
		if(arr[arr.length-1] == 7)
		{

			return arr.length-1;
		}
		else
		{

			return lastindexof7(newarr);
		}
	}

	public static int[] indexesof7(int[] arr,int beginindex)
	{

		if(beginindex == arr.length)
		{
			int ans[] = {};
			return ans;
		}

		int[] x = indexesof7(arr,beginindex+1);
		if(arr[beginindex] != 7)
		{
			return x;
		}
		int[] ans = new int[x.length+1];
		ans[0] = beginindex;
		for(int i = 0; i < x.length; i++)
		{
			ans[i+1] = x[i];
		}
		return ans;
	}

	public static int noofzeros(int num)
	{
		int count = 0;
		if(num == 0)
		{
			return 0;
		}
		if (num%10 == 0)
		{
			count++;
		}
		count = count + noofzeros(num/10);
		return count;

	}

	public static double gpofhalf(double k)
	{
		double ans;
		if (k == 0)
		{
			return 1;
		}
		ans = Math.pow(0.5, k) + gpofhalf(k-1);
		return ans;

	}

	public static int multiplication(int m, int n)
	{
		if(n == 1)
		{
			return m;
		}
		int mxn = m + multiplication(m,n-1);
		return mxn;				
	}

	public static boolean checkpalindrome(char[] arr, int startindex)
	{
		int n = arr.length-1;
		if(n%2 == 1)
		{
			if(startindex == (n+1)/2)
			{
				return true;
			}
		}
		if (n%2 ==0)
		{
			if(startindex == n/2 + 1)
			{
				return true;
			}
		}
		if(arr[startindex] == arr[n - startindex])
		{
			if(checkpalindrome(arr,startindex+1))
			{
				return  true;
			}
		}
		return false;
	}

	public static int strToInt(String str)
	{
		if(str.length() <= 0)
		{
			return 0;
		}
		int n = (int)(str.charAt(str.length()-1))-48;
		int ans = n + 10*strToInt(str.substring(0,str.length()-1));
		return  ans;
	}

	public static boolean checkreverse(char[] a, char[] b, int startindex)
	{	
		if (a.length != b.length)
		{
			return false;
		}
		int n = a.length-1;
		if(n%2 == 1)
		{
			if(startindex == (n+1)/2)
			{
				return true;
			}
		}
		if (n%2 ==0)
		{
			if(startindex == n/2 + 1)
			{
				return true;
			}
		}	
		if (a[startindex] == b[n -startindex])
		{
			if(checkreverse(a, b, startindex+1))
			{
				return true;
			}
		}
		return false;	
	}

	public static int sumofdigits(int num)
	{
		if(num == 0)
		{
			return 0;
		}
		return num%10 + sumofdigits(num/10);
	}

	public static String nox(String str)
	{
		String withoutx;
		if(str.length() == 0)
		{
			return str;
		}
		if(str.startsWith("x"))
		{
			withoutx = "";
		}
		else
		{
			withoutx = str.substring(0, 1);
		}
		return withoutx+nox(str.substring(1, str.length()));
	}

	public static String replacepi(String str)
	{
		String replaced;
		if(str.length() == 0)
		{
			return str;
		}
		if(str.startsWith("pi"))
		{
			replaced = "3.14";
		}
		else
		{
			replaced = str.substring(0, 1);
		}
		return replaced + replacepi(str.substring(1));
	}

	public static String identicalchars(String str)
	{
		String newstr;
		if(str.length() == 1 || str.length() == 0)
		{
			return str;
		}
		if(str.charAt(0) == str.charAt(1))
		{
			newstr = str.charAt(0) + "*" ;
			return newstr + identicalchars(str.substring(1 ,str.length()));
		}
		else
		{
			newstr = str.charAt(0) + "";
			return newstr + identicalchars(str.substring(1,str.length()));
		}

	}
	
	public static int polynomialEv(int coeff[], int x, int n)
	{
		int ans = 0;
		int temp = 1;
		for(int i = 0; i <= n; i++)
		{
			ans += coeff[i]*temp;
			temp = temp*x;
		}
		return ans;
	}

	public static void selsort(int[] arr, int startindex)
	{
		if(startindex == arr.length-1)
			return;
		int min = arr[startindex],i,x = startindex;
		for( i = startindex+1; i < arr.length; i++)
		{
			if(arr[i] < min)
			{
				min = arr[i];
				x = i;
			}
		}
		arr[x] = arr[startindex];
		arr[startindex] = min;
		selsort(arr, startindex+1);
	}

	public static void bubblesort(int[] arr, int endindex)
	{
		if(endindex <= 0 )
		{
			return;
		}
		int max = arr[0];
		int maxpos = 0;
		for(int i = 0; i <= endindex; i++)
		{
			if(arr[i] > max)
			{
				max = arr[i];
				maxpos = i;
			}
		}
		arr[maxpos] = arr[endindex];
		arr[endindex] = max;
		bubblesort(arr,endindex-1);

	}

	public static void bubblesort_(int[] arr, int endindex)
	{
		if(endindex <= 0 )
		{
			return;
		}
		int max = arr[0];
		for(int i = 0; i <= endindex; i++)
		{

			if(arr[i] > max)
			{
				max = arr[i];
				arr[i] = arr[endindex];
				arr[endindex] = max;
			}
		}

		bubblesort(arr,endindex-1);

	}

	public static int[] merge(int a[], int b[])	
	{
		int[] output = new int[a.length + b.length];
		merge_helper(a, b, output, 0, 0, 0);
		return output;
	}
	
	public static void merge_helper(int[] a, int[] b,int[] outputarr,int begina,int beginb,int arrindex)
	{
		// Base case
		if(begina == a.length)
		{
			while(beginb < b.length)
			{
				outputarr[arrindex] = b[beginb];
				beginb++;
				arrindex++;
			}
			return;
		}
		if(beginb == b.length)
		{
			while(begina < a.length)
			{
				outputarr[arrindex] = a[begina];
				begina++;
				arrindex++;
			}
			return;
		}
		
		
		
		// General case
		if(a[begina] < b[beginb])
		{
			outputarr[arrindex] = a[begina];
			begina++;
		}
		else
		{
			outputarr[arrindex] = b[beginb];
			beginb++;
		}
		merge_helper(a,b,outputarr,begina,beginb,arrindex+1);
	}

	public static void main(String[] args) {
		//		System.out.println(power(5,3));
		//		int[] arr ={1,2,3,45,67,7};
		//		System.out.println(check7(arr,0));
		//		System.out.println(multiplication(7,5));
		//		System.out.println(noofzeros(100));
		//		System.out.println(gpofhalf(4));
		//		char[] str = {'a','b','c','d','b','a'};
		//		char[] a = {'a','b','c','d'};		
		//		char[] b = {'d','c','b','a'};
		//		System.out.println(checkpalindrome(str, 0));
		//		System.out.println(checkreverse(a,b,0));
		//		//System.out.println(strToInt("1234",0));
		//		System.out.println(sumofdigits(12345));
		//		char[] x = {'d','x','c','x','b','x','d','a'};
		//		String xz = new String(x);
		//		System.out.println(nox(xz));
		//		String pi = "aspijfpipaefpikjn";
		//		System.out.println(replacepi(pi));
		//		String hello = "helllo";
		//		System.out.println(identicalchars(hello));
		//		String num = "1234";
		//		System.out.println(strToInt(num));
		//		int[] arr7 = {2,3,7,5,6,9,7};
		//		System.out.println(firstindexof7wi(arr7, 0));
		//		int[] ans = indexesof7(arr7, 0);
		//		printarray(ans);
		//		int[] arr = {3,4,1,6,8,5,2,9,7};
		//		bubblesort_(arr, 8);
		//		printarray(arr);
		
//		int arr[] = {1,3};
//		int arr2[] = {2,9,10};		
//		int ans[] = merge(arr,arr2);
//		printarray(ans);
		
		
		
		
		
	}

}
