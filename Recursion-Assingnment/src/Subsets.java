
public class Subsets {

	public static void printarraywithout0(int[] arr)
	{
		for(int i=0; i<arr.length ; i++)
		{
			if(arr[i] != 0)
			{
				System.out.print(arr[i]+" ");
			}
		}
	}

	public static void printarray(int[] arr)
	{
		for(int i=0; i<arr.length ; i++)
		{			
			System.out.print(arr[i]+" ");
		}
	}

	// Not Working.
	public static int[][] subsetsWithSumK(int[] input, int k)
	{
		if(k == 0)

		{
			int[][] arr = new int[1][1];
			arr[1] = input;
			return arr;
		}
		if(k < 0)
		{
			System.out.println("X");
			int[][] arr = new int[1][1];
			return arr;
		}
		if(input.length <= 0)
		{
			int[][] arr = new int[1][1];
			return arr;
		}
		int temp[] = new int[input.length-1];
		for(int i = 0; i < temp.length; i++)
		{
			temp[i] = input[i+1];
		}
		int[][] output1 = subsetsWithSumK(temp, k-input[0]);
		int[][] output2 = subsetsWithSumK(temp, k);
		int[][] output = new int[output1.length+output2.length][output1[0].length];
		int j = 0;
		for(int i = 0; i < output1.length; i++)
		{
			output[j] = output1[i];
			j++;
		}
		for(int i = 0; i < output2.length; i++)
		{
			output[j] = output2[i];
			j++;
		}
		return output;
	}

	// Returns 0 at empty spaces
	public static int[][] allSubsets(int[] input, int beginindex)
	{
		// Base Case
		if(beginindex == input.length)
		{
			int output[][] = new int[1][1];
			return output;
		}
		// General Case
		int[][] prev = allSubsets(input, beginindex + 1);
		int[][] current = new int[2*prev.length][prev[prev.length-1].length +1];
		int k = 0;
		for(int i = 0; i < prev.length; i++)
		{
			for(int j = 0; j < prev[i].length; j++)
			{
				current[k][j] = prev[i][j];
			}
			k++;
		}
		for(int i = 0; i < prev.length; i++)
		{
			for(int j = 0; j < prev[i].length; j++)
			{
				current[k][0] = input[beginindex];
				current[k][j+1] =  prev[i][j] ;
			}
			k++;
		}
		return current;
	}

	// Not working
	public static void printallSubsets(int[] input, int[] output)
	{
		if(input.length == 0)
		{
			printarray(output);
			System.out.println();
			return;
		}


		int[] temp = new int[input.length-1];
		for(int i = 0; i < temp.length; i++)
		{
			temp[i] = input[i+1];
		}
		for(int i = 0; i < temp.length; i++)
		{
			output[i] = temp[i];
		}
		printallSubsets(temp, output);
		for(int i = 0; i < output.length; i++)
		{
			output[i] = 0;
		}

		for(int i = 0; i < input.length; i++)
		{
			output[i] = input[i];
		}
		printallSubsets(temp, output);
	}

	public static void main(String[] args)
	{
		int arr[] = {1,2,3};
		
		
		//		int[][] output = allSubsets(arr,0);
		//		for(int i = 0; i < output.length; i++)
		//		{
		//			printarraywithout0(output[i]);
		//			System.out.println();
		//		}
		//		int output[] = {0,0,0,};
		//		printallSubsets(arr,  output);
		int output[][] = subsetsWithSumK(arr, 4);
		for(int i = 0; i < output.length; i++)
			printarray(output[i]);
	}

}
