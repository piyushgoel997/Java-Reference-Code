
public class PatternMatching {

	// Brute force approach
	public static int patternMatch(String text, String pattern){
		if(text.length() == 0 || pattern.length() == 0){
			return -1;
		}
		int i = 0;
		while(i <= text.length() - pattern.length()){
			int j = 0;
			while(j < pattern.length()){
				if(text.charAt(i) != pattern.charAt(j)){
					break;
				}
				j++;
				i++;
			}
			i = i - j;
			if(j == pattern.length()){
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String text = "abacdabcd";
		String pattern = "abg";
		System.out.println(patternMatch(text, pattern));
	}

}
