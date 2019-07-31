
public class Polynomial {
	private PolyPair[] poly;
	private int size;
	
	public Polynomial(){
		poly = new PolyPair[10];
		for(int i = 0; i < 10; i++){
			poly[i] = new PolyPair(0, 0);
		}
		size = 0;
	}

	public void setCoefficient(int coeff, int pow){
		if(size >= poly.length -1){
			doubleSize();
		}
		int x = binSearch(pow);
		if(x != -1){
			poly[x].coeff = coeff;
		}else{
			int i = 0;
			while(i < size){
				if(pow < poly[i].pow){
					break;
				}
				i++;
			}
//			poly[size] = new PolyPair(poly[size-1].coeff, poly[size-1].pow);
			for(int j = size - 1; j > i; j--){
				poly[j].coeff = poly[j-1].coeff;
				poly[j].pow = poly[j-1].pow;
			}
			poly[i].pow = pow;              // Null Pointer Exception.
			poly[i].coeff = coeff;
//			poly[i] = new PolyPair(pow, coeff);
			size++;
		}		
	}

	public int sizeOf(){
		return size;
	}

	private int binSearch(int pow){
		int n = poly.length/2, start = 0, end = poly.length;
		while(n < size && n >= 0){
			if(pow == poly[n].pow){
				return n;
			}else if(pow > poly[n].pow){
				start = n;
				n = (n + end)/2;
			}else{
				end = n;
				n = (n + start)/2;
			}
		}
		return -1;
	}

	private void doubleSize(){
		PolyPair[] temp = new PolyPair[poly.length*2];
		int i;
		for(i = 0; i < poly.length; i++){
			temp[i] = poly[i];
		}
		for(; i < temp.length; i++){
			poly[i] = new PolyPair(0, 0);
		}
		poly = temp;
		size = 2*(poly.length);
	}

	public int degree(){
		return poly[size - 1].pow;
	}

	public int evaluate(int x){
		int ans = 0;
		for(int i = 0; i < poly.length; i++){
			ans += poly[i].coeff*(Math.pow(x, poly[i].pow));
		}
		return ans;
	}

/*	public Polynomial add(Polynomial p){
		int aptr = 0, bptr = 0;
		Polynomial ans = new Polynomial();
		while(aptr < poly.length && bptr < p.sizeOf()){
			if(poly[aptr].pow == p.poly[bptr].pow){
				ans.setCoefficient(poly[aptr].coeff + p.poly[bptr].coeff, poly[aptr].pow);
				aptr++;
				bptr++;
			}else if(poly[aptr].pow > p.poly[bptr].pow){
				ans.setCoefficient(p.poly[bptr].coeff, p.poly[bptr].pow);
				bptr++;
			}else{
				ans.setCoefficient(poly[aptr].coeff, poly[aptr].pow);
				aptr++;
			}
		}
		while(aptr < poly.length){
			ans.setCoefficient(poly[aptr].coeff, poly[aptr].pow);
			aptr++;
		}
		while(bptr < p.sizeOf()){
			ans.setCoefficient(p.poly[bptr].coeff, p.poly[bptr].pow);
			bptr++;
		}
		return ans;
	}
*/

	public Polynomial add2(Polynomial p){
		int aptr = 0, bptr = 0;
		Polynomial ans = new Polynomial();
		while(aptr < poly.length){
			ans.setCoefficient(poly[aptr].coeff, poly[aptr].pow);
			aptr++;
		}
		while(bptr < p.sizeOf()){
			ans.setCoefficient(p.poly[bptr].coeff, p.poly[bptr].pow);
			bptr++;
		}
		return ans;
	}
	
	public Polynomial subtract(Polynomial p){
		int aptr = 0, bptr = 0;
		Polynomial ans = new Polynomial();
		while(aptr < poly.length){
			ans.setCoefficient(poly[aptr].coeff, poly[aptr].pow);
			aptr++;
		}
		while(bptr < p.sizeOf()){
			ans.setCoefficient(-p.poly[bptr].coeff, p.poly[bptr].pow);
			bptr++;
		}
		return ans;
	}
	
	public Polynomial multiply(Polynomial p){
		int aptr = 0, bptr = 0;
		Polynomial ans = new Polynomial();
		while(aptr < poly.length){
			while(bptr < p.sizeOf()){
				ans.setCoefficient(poly[aptr].coeff*p.poly[bptr].coeff, poly[aptr].pow + p.poly[bptr].pow);
			}
		}
		return ans;
	}

	public void printPoly(){
		for(int i = 0; i < size; i++){
			System.out.println("("+poly[i].coeff+","+poly[i].pow+")");
		}
	}
}
