import java.util.HashMap;

public class GreaterNos {

	public static int greaternos(int n){
		int count = 0, len = 0, temp =  n;
		// for finding the length of the number
		while(temp > 0){
			temp = temp/10;
			len++;
		}
		// storing the number in an array (for ease)
		int[] num = new int[len];
		for(int i = 0; i < len; i++){
			temp = n%10;
			num[len - i - 1] = temp;
			n /= 10;
		}		
		// main work
		for(int i = 0; i < len -1; i++){
			int ct = 0;
			for(int j = i + 1; j < len; j++){
				if(num[i] < num[j]){         // counting numbers fit for that place
					ct++;        
				}
			}
			count += ct*factorial(len-i-1);
		}
		return count;	
	}

	/*public static int greaternosRep(int n){
		int count = 0, len = 0, temp =  n;
		// for finding the length of the number
		while(temp > 0){
			temp = temp/10;
			len++;
		}
		// putting the num in hashmap.
		HashMap<Integer, Integer> map = new HashMap<>();
		while(temp > 0){
			int current = temp%10;
			temp = temp/10;
			map.put(current, map.get(current) + 1);
		}
		// storing the number in an array (for ease)
		int[] num = new int[len];
		for(int i = 0; i < len; i++){
			temp = n%10;
			num[len - i - 1] = temp;
			n /= 10;
		}
		// main work
		for(int i = 0; i < num.length - 1; i++){
			for(int j = 0; j < num.length; j++){
				int tempCount = 0;
				
				if(num[j] > num[i]){
					
					
					
				}
				
				count += tempCount;
			}

		}
		
		return count;
	}
*/
	/*	public static int factRepetetion(int[] arr, int beginindex, int excludedindex){
		int ans = 1;
		int[] temparr = new int[9];
		for(int i = 0; i < temparr.length; i ++){
			temparr[i] = 0;
		}
		for(int i = beginindex; i < arr.length; i ++){
			if(i != excludedindex){
				temparr[arr[i]]++;
			}
		}
		for(int i = 0; i < temparr.length; i++){
			ans *= factorial(temparr[i]); 
		}
		return ans;
	}*/

	public static int factRepetetion(int[] arr, int beginindex){
		int ans = 1;
		int[] temparr = new int[9];
		for(int i = 0; i < temparr.length; i ++){
			temparr[i] = 0;
		}
		for(int i = beginindex; i < arr.length; i ++){

			temparr[arr[i]]++;

		}
		for(int i = 0; i < temparr.length; i++){
			ans *= factorial(temparr[i]); 
		}
		return ans;
	}

	public static int factorial(int num){
		if(num <= 1){
			return 1;
		}
		return num*factorial(num-1);
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,3,3,6,6,4,1};
		System.out.println(factRepetetion(arr, 0));
		System.out.println(greaternos(1234));
	}
}
