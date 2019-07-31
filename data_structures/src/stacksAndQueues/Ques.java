package stacksAndQueues;

import java.util.Scanner;

public class Ques {
	
	/*public static boolean checkBracket(String input) throws StackEmpty{
		Stack<Character> exp = new Stack<>();
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(iaa) == '{' && temp == '[' && temp == '(')
			exp.push(input.charAt(i));
		}
		Stack<Character> exp2 = new Stack<>();
		while(!exp.isEmpty()){
			char temp = exp.pop();
			if(temp == '{' && temp == '[' && temp == '(')
				exp2.push(temp);
			if(temp == '}')
				if(exp2.pop() != '{')
					return false;
			if(temp == ')')
				if(exp2.pop() != '(')
					return false;
			if(temp == '[')
				if(exp2.pop() != ']')
					return false;
		}
		return true;
	}*/
	
	public static void reverse(Stack<Integer> input) throws StackEmpty{
		if(input.isEmpty()){
			return;
		}
		int temp = input.pop();
		reverse(input);
		Stack<Integer> extra = new Stack<>();
		while(!input.isEmpty()){
			extra.push(input.pop());
		}
		input.push(temp);
		while(!extra.isEmpty()){
			input.push(extra.pop());
		}
	}
	
	public static boolean checkDuplicate(String input){
		int i = 0, j = 0;
		for(int k = 0; k < input.length(); k++){
			if(input.charAt(i) == '('){
				i++;
			}
			if(input.charAt(i) == ')'){
				j++;
			}
		}
		return i != j;
	}
	
	public static Spans[] span(Stack<Integer> prices) throws StackEmpty{
		Spans[] si = new Spans[10];
		int current = prices.top();
		int i = prices.sizeOf(),k = 0;
		while(!prices.isEmpty()){
			while(prices.pop() > current){
				i--;
			}
			int end = i;
			while(prices.pop() <= current){
				i--;
			}
			int start = i;
			si[k] = new Spans(start,end);
			k++;			
		}
		return si;
	}
	
	public static void main(String[] args) throws StackEmpty{
//		System.out.println("enter expression");
//		Scanner s = new Scanner(System.in);
//		String str = s.next();
//		System.out.println(checkBracket(str));
		Stack<Integer> s = new Stack<>();
		for(int i = 1; i < 5; i++){
			s.push(i);
		}
		reverse(s);
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}

}
