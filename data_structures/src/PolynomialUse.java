
public class PolynomialUse {
	
	public static void main(String[] args){
		Polynomial a = new Polynomial();
		
//		Polynomial b = new Polynomial();
//		for(int i = 0; i < 7; i++){
//			b.setCoefficient(i+2, i+1);
//		}
		for(int i = 0; i < 8; i += 2){
			a.setCoefficient(i+2, i);
		}
		for(int i = 0; i < 6; i++){
			a.setCoefficient(i, i);
		}
		a.printPoly();
		
	}

}
