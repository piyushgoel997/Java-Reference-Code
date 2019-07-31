import java.util.Scanner;

public class PrimeNos {
	public static void main(String[] args){
		int i=2,n,j;
		Scanner s = new Scanner(System.in);
		System.out.println("enter a number");
		n = s.nextInt();
		while(i<=n){
			j=2;
			while(j<i){
				if(i%j==0){
					break;
				}
				j++;
			}
			if(j==i){
				System.out.println(i);
			}
							
			i++;
		}
		s.close();
	}

}
