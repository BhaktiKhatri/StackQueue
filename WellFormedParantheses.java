package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class WellFormedParantheses {

	public static boolean isWellFormed(String s) {
		Deque<Character> leftChars = new ArrayDeque<>();
		System.out.println("s: "+s);
		
		for(int i=0; i<s.length(); ++i) {
			System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" leftChars: "+leftChars);
			
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				leftChars.addFirst(s.charAt(i));
			}
			else {
				if(leftChars.isEmpty()) {
					return false; 	//unmatched right char
				}
				
				if(s.charAt(i) == ')' && leftChars.peekFirst() != '(' || s.charAt(i) == '}' && leftChars.peekFirst() != '{' || s.charAt(i) == ']' && leftChars.peekFirst() != '[') {
					return false; 	//mismatched chars
				}
				
				leftChars.removeFirst();
			}
		}
		return leftChars.isEmpty();
	}
	
	public static void main(String[] args) {
		String s = "[()]";
		System.out.println(isWellFormed(s));
	}

}
