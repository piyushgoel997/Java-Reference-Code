import java.util.Scanner;

public class AggressiveCows {
	
	public static void mergesort(int[] arr)
	{
		if(arr.length == 1)
		{
			return;
		}	
		int[] split1 = new int[arr.length/2];
		int[] split2 = new int[arr.length - arr.length/2];

		int k =0;

		for(int j = 0; j < split1.length; j++)
		{
			split1[j] = arr[k];
			k++;
		}
		for(int j = 0; j < split2.length; j++)
		{
			split2[j] = arr[k];
			k++;
		}

		mergesort(split1);
		mergesort(split2);
		int x[] = merge(split1,split2);
		for(int i = 0; i < x.length; i++)
		{
			arr[i] = x[i];
		}		
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

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int m = 0; m < t; m++)
		{
			int n = s.nextInt(), c = s.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
			{
				arr[i] = s.nextInt();
			}
			mergesort(arr);
//			int x,y,z,min = 0,max = 0;
//			for(int i = 0; i < n-2; i++)
//			{
//				for(int j = i+1; j < n-1; j++)
//				{				
//					for(int k = j+1; k < n; k++)
//					{
//						x = arr[i] - arr[j];
//						y = arr[j] - arr[k];
//						z = arr[k] - arr[i];
//						if(x < 0)
//							x = -x;
//						if(y < 0)
//							y = -y;
//						if(z < 0)
//							z = -z;
//						if(x < y && x < z)
//							min = x;
//						else if (y < x && y < z)
//							min = y;
//						else
//							min = z;
//						if(min > max)
//							max = min;
//					}
//				}
//			}
//			System.out.println(max);
			
			int x,max = 0;
			for(int i = 0; i < n-1; i++)
			{
				x = arr[i+1] - arr[i];
				if(x > max)
					max = x;
			}
			System.out.println(max);
		}
	}

}
