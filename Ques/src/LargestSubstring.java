
public class LargestSubstring {

	public static String largestSubstring(String input){
		int css = 0, mss = 0, mse = 1;
		int[] arr = new int[256];
		for(int j = 0; j < arr.length; j++){
			arr[j] = -1;
		}
		while(css < input.length()){
			int i = css+1;
			while(arr[input.charAt(i)] == -1 && i < input.length()){
				arr[input.charAt(i)] = i;
				i++;
			}
			if((mse - mss) < (i - css)){
				mss = css;
				mse = i;
			}
			css++;
		}
		return input.substring(mss,mse);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abacdaefa";
		System.out.println(largestSubstring(str));
	}

}
