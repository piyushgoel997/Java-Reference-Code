import java.util.Scanner;

public class RootsQuadratic {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("enter a,b,c of ax^2 + bx +c = 0");
		float a = s.nextFloat();
		float b = s.nextFloat();
		float c = s.nextFloat();
		
		float D;
		D = b*b - 4*a*c ;
				
		if (D>=0){
			float r1 = (float) (( -b + Math.sqrt(D) )/(2*a)) ;
			float r2 = (float) (( -b - Math.sqrt(D) )/(2*a)) ;
			System.out.println("the roots are real and are "+r1+" and "+r2);
		}
		else {
	    float d = (float) (( Math.sqrt(-D) /(2*a))) ;
		float x;
		x = -(b/(2*a));
		System.out.println("the roots are complex and are"+x+"+i"+d+" and "+x+"-i"+d);
		}
		s.close();
		
	}

}
