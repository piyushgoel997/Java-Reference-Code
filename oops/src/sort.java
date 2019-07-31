import java.util.Scanner;

public class sort {
	
	public static<T extends compareInterface<T>> void  sort(T[] input)
	{
		T temp;
		for(int i = 0; i < input.length; i++)
		{
			for(int j = 0; j < input.length - i - 1; j++)
			{
				if(input[j].compareTo(input[j+1]) == 1)
				{
					temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}
			}
		}
	}
	
	
	public static<T extends compareInterface<T>> pair minMax(T[] input)
	{
		T min = input[0],max=input[0];
		for(int i = 1; i < input.length; i++)
		{
			if(input[i].compareTo(min) == -1)
			{
				min = input[i];
			}
			if(input[i].compareTo(max) == 1)
			{
				max = input[i];
			}
		}
		pair<T> p = new pair<>();
		p.min = min;
		p.max = max;
		return p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Students[] s = new Students[5];
		Scanner x = new Scanner(System.in);
		for(int i = 0; i < s.length; i++)
		{
			s[i] = new Students();
			s[i].marks = x.nextInt();
		}
//		sort(s);
//		for(int i = 0; i < s.length; i++)
//		{
//			System.out.println(s[i].marks);
//		}
		pair<Integer> p = minMax(s);
		System.out.println("Min :"+p.min+" Max :"+p.max);	
	}
}
