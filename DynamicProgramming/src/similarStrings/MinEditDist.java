package similarStrings;

public class MinEditDist {

	public static int med(String a, String b){
		if(a.length() == 0 || b.length() == 0){
			return Math.max(a.length(), b.length());
		}

		if(a.charAt(0) == b.charAt(0)){
			return med(a.substring(1), b.substring(1));
		}else{
			int del = 1 + med(a.substring(1),b);
			int ins = 1 + med(a, b.substring(1));
			int sub = 1 + med(a.substring(1), b.substring(1));
			return Math.min(del, Math.min(ins, sub));
		}
	}

	public static int medBetter(String a, String b){
		int[][] storage = new int[a.length() + 1][b.length() + 1];
		for(int i = 0; i < storage.length; i++){
			for(int j = 0; j < storage[0].length; j++){
				storage[i][j] = -1;
			}
		}
		return medBetter(a, b, storage);
	}

	private static int medBetter(String a, String b, int[][] storage) {
		if(a.length() == 0 || b.length() == 0){
			return Math.max(a.length(), b.length());
		}

		if(storage[a.length()][b.length()] != -1){
			return storage[a.length()][b.length()];
		}else{
			if(a.charAt(0) == b.charAt(0)){
				return medBetter(a.substring(1), b.substring(1),storage);
			}else{
				int del = 1 + medBetter(a.substring(1),b, storage);
				int ins = 1 + medBetter(a, b.substring(1), storage);
				int sub = 1 + medBetter(a.substring(1), b.substring(1), storage);
				storage[a.length()][b.length()] = Math.min(del, Math.min(ins, sub));
				return storage[a.length()][b.length()];
			}
		}
	}
	
	
	public static int medDP(String a, String b){
		int m = a.length(), n = b.length();
		int[][] storage = new int[m + 1][n + 1];
		for(int i = 0; i < storage[0].length; i++){
			storage[0][i] = i;
		}
		for(int i = 0; i < storage.length; i++){
			storage[i][0] = i;
		}
		for(int i = 1; i < m + 1; i++){
			for(int j = 1; j < n + 1; j++){
				if(a.charAt(m - i) == b.charAt(n - j)){
					storage[i][j] = storage[i - 1][j - 1];
				}else{
					storage[i][j] = 1 + Math.min(storage[i - 1][j - 1], Math.min(storage[i][j - 1], storage[i - 1][j]));
				}
			}
		}
		return storage[m][n];
	}
		

	public static void main(String[] args) {
		String a = "ac";
		String b = "dbc";
		System.out.println(medDP(a, b));
	}

}
