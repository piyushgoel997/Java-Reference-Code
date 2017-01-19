
public class improvePow {

	public static int pow(int x, int n)
	{
		if(n == 0)
			return 1;
		if(n == 1)
			return x;
		return pow(x,n/2)*pow(x,n-n/2);
	}

	public static void main(String[] args) {
		System.out.println(pow(3,4));
	}
}