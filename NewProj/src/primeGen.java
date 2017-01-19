import java.util.*;
import java.lang.*;
 
class primeGen
{
	public static void primeGenerator(int m, int n){
		for(int i = m; i <= n; i++){
			if(checkPrime(i)){
//				System.out.println(i);
			}
		}
	}
 
	public static boolean checkPrime(int x){
		for(int i = 2; i < x; i++){
			if(x % i == 0){
				return false;
			}
		}
		return true;
	}
 
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int noOfTestCases = s.nextInt();
		for(int i = 0; i < noOfTestCases; i++){
			int m = s.nextInt();
			if(m < 2){
				m = 2;
			}
			int n = s.nextInt();
			primeGenerator(m, n);
			System.out.println();
		}
		System.out.println(System.nanoTime());
		s.close();
	}
}