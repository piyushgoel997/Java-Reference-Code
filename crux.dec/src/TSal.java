import java.util.Scanner;

public class TSal {
	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		System.out.println("enter basic");
		int basic = s.nextInt();
		System.out.println("enter grade");
		char grade = s.next().charAt(0);
		
		int allow=0;
		
		if (grade==65){
			allow = 1700;
		}
		
		if (grade==66){
			allow = 1500;
		}
		
		if (grade==63){
			allow = 1300;
		}
		
		float tsal;
		tsal = (float) (1.59*basic + allow) ;
		
		System.out.println("the total salary is "+tsal);
		
		s.close();
		
	}
	
}
