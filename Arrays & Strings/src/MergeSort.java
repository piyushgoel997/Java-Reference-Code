
public class MergeSort {


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

	public static void printarray(int[] arr)
	{
		for(int i=0; i<arr.length ; i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		int[] arr = {6,4,8,5,9,1};
		mergesort(arr);
		printarray(arr);
	}

}
