import java.util.Scanner;

public class nameAndAvg {
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		System.out.println("enter the name of the student");
		String name = s.next();
		System.out.println("enter the marks of three subjects");
		int m1 = s.nextInt();
		int m2 = s.nextInt();
		int m3 = s.nextInt();
		float avg;
		if (m1<m2 && m1<m3){
			avg=(float)(m2+m3)/2;
		}
		else if (m2<m1 && m2<m3){
			avg=(float)(m1+m3)/2;
		}
		else {
			avg=(float)(m1+m2)/2;
		}
		System.out.println(name+" "+avg);
		s.close();
		
	}

}
