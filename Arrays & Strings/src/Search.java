import java.util.Scanner;

public class Search 
{
	public static int[] takeinput()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = s.nextInt();
		int[] arr = new int[size];
		for(int i=0; i< size; i++)
		{
			System.out.println("enter "+i+" term");
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static int linearsearch(int[] arr, int x)
	{	
		for(int i = 0; i < arr.length; i++)
		{
			if (arr[i] == x)
			{
				return i;
			}
		}
		return -1;	
	}
	
	
	public static int binarysearch(int[] arr, int k)
	{
		int n = (arr.length)/2, start = 0, end = arr.length;
		while(n >= 0 || n < arr.length){
			if (k < arr[n]){
				end = n;
				n = (start + n)/2;
				
			}
			if (k > arr[n]){
				start = n;
				n = (n + end)/2;
				
			}
			if (k == arr[n]){
				return n;
			}
		}
		return -1;		
	}


	public static void main(String[] args) 
	{
		int[] arr = takeinput();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the element to be searched");
		int k = s.nextInt();
		int x = binarysearch(arr,k);
		if(x!=-1){
			System.out.println("the position of the term you searched is "+x);
		}
		else{
			System.out.println("the element is not in the array");
		}  
	}

}
