
public class Strairs {
	
	// Any way to do without using array.
	// Array is used so that the value may be upgraded and not overwritten every time.
	public static void childproblem(int n, int[] ans)
	{
		if(n > 0)
		{
			childproblem(n-1, ans);
			childproblem(n-2, ans);
			childproblem(n-3, ans);
		}
		if(n == 0)
			ans[0] += 1;
		if(n < 0)
			return;
	}

	public static void main(String[] args) {
		int ans[] = {0};
		childproblem(4, ans);
		System.out.println(ans[0]);
	}
	
}
