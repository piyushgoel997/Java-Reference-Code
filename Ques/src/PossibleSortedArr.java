
public class PossibleSortedArr {
	// Wrong. see from class code. 
	public static int noOfSortedArrs(int[] a, int[] b){
		int count = 1;
		int prev = 1, curr = 0;
		int i = 0, j = 0;
		while(i < a.length && j < b.length){
			if(b[j] > a[i]){
				curr = prev + 1;
				prev = curr;
				count += curr;
				i++;
			}
			
			
			if(i < a.length && a[i] > b[j]){
				curr = prev + 1;
				prev = curr;
				count += curr;
				j++;
			}			
			
		}
		return count;
	}
	
	
	public static void main(String[] args){
		int[] a = {1,3,5,7};
		int[] b = {2,4,6,8};
		System.out.println(noOfSortedArrs(a, b));
	}

}
