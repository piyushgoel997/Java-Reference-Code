import java.util.Scanner;

public class MultiDimArray {


	public static int[][] takeinput2D()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no.of rows and cols");
		int row = s.nextInt();
		int col = s.nextInt();
		int arr[][] = new int[row][col];
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				System.out.println("enter element of "+i+" row and "+j+" col");
				arr[i][j] = s.nextInt();
			}
		}
		return arr;
	}


	public static void waveprint(int input[][])
	{
		int row = input.length;
		int col = input[0].length;
		int i;
		int j = 0;
		while(j < col)
		{
			for(i = 0; i < row; i++)
			{
				System.out.print(input[i][j]);
			}
			j++;
			if(j < col)
			{
				for(i = i-1; i >= 0; i--)
				{
					System.out.print(input[i][j]);
				}
				j++;
			}
		}		
	}
	
	
	public static void spiralprint(int input[][])
	{
		int row = input.length;
		int col = input[0].length;
		int min;
		if (row > col)
		{
			min = col;
		}
		else
		{
			min = row;
		}
		int i = 0;
		int j = 0;
		int k = 0;
		while( k < min/2 )
		{
			   if(col > 0)
			   {
				for(j = j; j < col; j++)
				{
					System.out.print(input[i][j]+" ");
				}
			   }
			   else break;
				i++;
				j--;
				if(row > 0)
				{
				for(i = i; i < row; i++)
				{
					System.out.print(input[i][j]+" ");
				}
				}
				else break;
				i--;
				j--;
				
				for(j = j; j >= k; j--)
				{
					System.out.print(input[i][j]+" ");
				}
				j++;
				i--;
				k++;
				for(i = i; i >= k; i--)
				{
					System.out.print(input[i][j]+" ");
				}
				
				i++;
				j++;
				col--;
				row--;
			
		}
		
		
	}



	public static void main(String[] args) {
		spiralprint(takeinput2D());
	}

}
