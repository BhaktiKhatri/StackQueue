package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class EvaluateRPNExpressions {

	public static int eval(String RPNExpression) {
		if(RPNExpression.length() == 0)
			return 0;
		
		System.out.println("RPNExpression: "+RPNExpression);
		Deque<Integer> intermediateResults = new ArrayDeque<>();		//LIFO
		String delimeter = ",";
		String[] symbols = RPNExpression.split(delimeter);
		System.out.println("symbols: "+Arrays.toString(symbols));
		
		for(String token: symbols) {
			System.out.println("token: "+token);
			
			if(token.length() == 1 && "+-*/".contains(token)) {
				
				final int y = intermediateResults.removeFirst();
				final int x = intermediateResults.removeFirst();
				System.out.println("y: "+y+" x: "+x+" token.charAt(0): "+token.charAt(0));
				
				switch(token.charAt(0)) {
				case '+':
					intermediateResults.addFirst(x + y);
					break;
				case '-':
					intermediateResults.addFirst(x - y);
					break;
				case '*':
					intermediateResults.addFirst(x * y);
					break;
				case '/':
					intermediateResults.addFirst(x / y);
					break;
				default:
					throw new IllegalArgumentException("Malformed RPN at: "+token);
				}
			}
			else {	//token is a number
				System.out.println("token: "+token+" intermediateResults: "+intermediateResults);
				intermediateResults.addFirst(Integer.parseInt(token));
			}
		}
		return intermediateResults.removeFirst();
	} 
	
	
	/*
	 * if(y != 0) {
					    intermediateResults.add(x / y);
                        break;
                    }
                    else {
                        throw new ArithmeticException("Divide by 0 is not allowed!");    
                    } 
	 */
	
	public static void main(String[] args) {
		//String RPNExpression = "3,4,+,2,*,1,+";
		String RPNExpression = "1,1,+,-2,*";
		System.out.println("Result: "+eval(RPNExpression));
	}

}
