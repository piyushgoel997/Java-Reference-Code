
public class Factors {

	public static double[] factors(double num){
		int k = 0, i;
		// to count the no of factors upto sqrt(n)
		for(i = 1; i < Math.sqrt(num); i++){
			if(num%(i) == 0){
				k++;
			}
		}
		// length of the factor array
		int len;
		if(i == Math.sqrt(num)){
			len = 2*k+1;
		}
		else
			len = 2*k;
		double arr[] = new double[len];
		k = 0;
		for(i = 1; i <= Math.sqrt(num); i++){
			if(num%(i) == 0){
				arr[k] =  i;
				if(i != Math.sqrt(num))
					arr[len - k - 1] = num/(i);
				k++;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		double arr[] = factors(81);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}

}
