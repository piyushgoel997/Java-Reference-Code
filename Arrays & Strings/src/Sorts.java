import java.util.Scanner;

public class Sorts 
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
		s.close();
		return arr;

	}

	public static void printarray(int[] arr)
	{
		for(int i=0; i<arr.length ; i++)
		{
			System.out.print(arr[i]);
		}
	}
	

	public static void selectionsort(int[] arr)
	{
		for(int i = 0; i < arr.length -1; i++)
		{
			int min = arr[i];
			int minj = i;
			for (int j = i+1; j < arr.length; j++)
			{
				if(arr[j] < min)
				{
					min = arr[j];
					minj = j;
				}				
			}
			int x = arr[i];
			arr[i] = arr[minj];
			arr[minj] = x;
		}		
	}

	public static void insertionsort(int arr[])
	{
		for (int i = 0; i < arr.length; i++ )
		{			
			for(int j = i-1; j >= 0; j--)
			{
				if(arr[j] > arr[i])
				{
					int x = arr[j];
					arr[j] = arr[i];
					arr[i] = x;
					i = j;
				}
			}			
		}		
	}


	public static void bubblesort(int[] arr)
	{		
		for(int i = 0; i < arr.length -1; i++)
		{
			int min = arr[i],pos = i;
			for(int j = i+1; j < arr.length; j++)
			{
				if(arr[j] < min)
				{
					min = arr[j];
					pos = j;
					arr[pos] = arr[i];
					arr[i] = min;
				}
			}						
		}		
	}



	public static void main(String[] args) 
	{
		int arr[] = takeinput();
		//	selectionsort(arr);
		//	insertionsort(arr);
			bubblesort(arr);
		System.out.println("The sorted arrary is ");
		printarray(arr);
	}

}
