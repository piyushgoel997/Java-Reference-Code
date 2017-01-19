public class QuickSort {

	public static void printarray(int[] arr)
	{
		for(int i=0; i<arr.length ; i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

	public static void quicksort(int[] input, int beginindex, int endindex)
	{
		if(beginindex >= endindex)
		{
			return;
		}
		int pivotPos = partition(input,beginindex,endindex);
		quicksort(input, beginindex , pivotPos-1);
		quicksort(input,pivotPos+1,endindex);		
	}


	public static int partition(int[] input, int beginindex, int endindex)
	{
		int count = beginindex;
		for(int i = beginindex; i <= endindex; i++)
		{
			if(input[i] < input[beginindex])
				count++;
		}
		int temp;
		temp = input[count];
		input[count] = input[beginindex];
		input[beginindex] = temp;
		int  i = beginindex, j = endindex;
		while(i < count && j > count)
		{
			while(input[i] < input[count])
			{
				i++;
			}
			while(input[j] > input[count])
			{
				j--;
			}
			temp = input[i];
			input[i] = input[j];
			input[j] = temp;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {5,6,2,9,1,3,10};
		quicksort(input, 0, input.length-1);
		printarray(input);
	}

}
