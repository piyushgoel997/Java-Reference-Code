import java.util.Scanner;

public class R1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
				Scanner s = new Scanner(System.in);
				int n = s.nextInt();
				int a[] = new int [n];
				for(int i = 0; i < n; i++)
				{
					a[i] = s.nextInt();
				}
				int m = s.nextInt();
				int b[] = new int [m];
				for(int i = 0; i < m; i++)
				{
					b[i] = s.nextInt();
				}
				for(int i = 0; i < n; i++)
				{
					int j;
					for(j = 0; j < m; j++)
					{
						if(a[i] == b[j])
						{
							break;
						}
					}
					if(j == m)
					{
						System.out.print(a[i]+" ");
					}
				}
				s.close();
			
	}

}
