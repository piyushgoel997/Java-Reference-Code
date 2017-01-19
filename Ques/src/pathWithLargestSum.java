
public class pathWithLargestSum {
	
	public static int pathLargestSum(int input1[], int input2[]){
		int i = 0, j = 0;
		int sum = 0;
		while(i < input1.length && j < input2.length){
			int sum1 = 0, sum2 = 0;
			while(input1[i] != input2[j] && (i < input1.length && j < input2.length)){
				if(input1[i] < input2[j]){
					sum1 += input1[i];
					i++;
				}else{
					sum2 += input2[j];
					j++;
				}
			}
			sum += input1[i];
			i++;
			j++;
			if(sum1 > sum2){
				sum += sum1;
			}else{
				sum += sum2;
			}
			
			if(i == input1.length && input1[i-1] == input2[j - 1]){
				while(j < input2.length){
					sum += input2[j];
					j++;
				}
			}
			else if(j == input2.length && input1[i-1] == input2[j - 1]){
				while(i < input1.length){
					sum += input1[i];
					i++;
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int input1[] = {1,2,5,10,30};
		int input2[] = {3,5,10,15,16};
		System.out.println(pathLargestSum(input1, input2));
	}

}
