package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Stack;

public class EvaluatePrefixExpressions {

	public static int eval(String PExpression) {
		System.out.println("PExpression: "+PExpression);
		
		Deque<Integer> intermediateResults = new ArrayDeque<>();
		String delimeter = ",";
		String[] symbols = PExpression.split(delimeter);
		Collections.reverse(Arrays.asList(symbols));
		System.out.println("symbols: "+Arrays.toString(symbols));
		
		for(String token: symbols) {
			System.out.println("token: "+token);
			if(token.length() == 1 && "+-*/".contains(token) && !intermediateResults.isEmpty()) {
				int y = intermediateResults.removeFirst();
				int x = intermediateResults.removeFirst();
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
			else {	//token has numbers only
				System.out.println("token: "+token+" intermediateResults: "+intermediateResults);
				intermediateResults.addFirst(Integer.parseInt(token));
			}
		}
		
		return intermediateResults.removeLast();
	}
	
	//Refer this
	public static int evalPrefix(String[] tokens) {
        if(tokens.length == 0) {
            return 0;
        }
        else if(tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        System.out.println("tokens: "+Arrays.toString(tokens));
        
		Stack<Integer> stack = new Stack<>();		//LIFO
		
		for(int i=tokens.length-1; i>=0; i--) {
			System.out.println("tokens[i]: "+tokens[i]+" stack: "+stack);
			
			if(tokens[i].length() == 1 && "+-*/".contains(tokens[i])) {
				
				final int x = stack.pop();
				final int y = stack.pop();
				System.out.println("y: "+y+" x: "+x);
				
				switch(tokens[i].charAt(0)) {
				case '+':
					stack.add(x + y);
					break;
				case '-':
					stack.add(x - y);
					break;
				case '*':
					stack.add(x * y);
					break;
				case '/':
					stack.add(x / y);
					break;
				default:
					throw new IllegalArgumentException("Malformed RPN at: "+tokens[i]);
				}
			}
			else {	//token is a number
				stack.add(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
    }
	
	//https://www.geeksforgeeks.org/evaluation-prefix-expressions/
	public static double evaluatePrefix(String[] tokens) 
	{ 
	    Stack<Integer> Stack = new Stack<Integer>(); 
	   
	    for (int i = tokens.length - 1; i >= 0; i--) { 
	   
	        // Push operand to Stack 
	        // To convert exprsn[j] to digit subtract 
	        // '0' from exprsn[j]. 
	    	if(tokens[i].length() == 1 && "+-*/".contains(tokens[i])) {  
	           
	            // Operator encountered 
	            // Pop two elements from Stack 
	            int o1 = Stack.peek(); 
	            Stack.pop(); 
	            int o2 = Stack.peek(); 
	            Stack.pop(); 
	   
	            // Use switch case to operate on o1  
	            // and o2 and perform o1 O o2. 
	            switch(tokens[i].charAt(0)) { 
	            case '+': 
	                Stack.push(o1 + o2); 
	                break; 
	            case '-': 
	                Stack.push(o1 - o2); 
	                break; 
	            case '*': 
	                Stack.push(o1 * o2); 
	                break; 
	            case '/': 
	                Stack.push(o1 / o2); 
	                break; 
	            } 
	        } 
	    	else {
	    		Stack.add(Integer.parseInt(tokens[i]));
	        }
	    } 
	    return Stack.peek(); 
	} 
	  
	
	
	public static void main(String[] args) {
		String PExpression = "+,9,*,2,6";
		//System.out.println(eval(PExpression));
		String[] tokens = {"-","+","7","*","4","5","+","2","0"};//{"+","9","/","2","6"}; //{"-","+","7","*","4","5","+","2","0"}; //{"+","9","*","2","6"};
		System.out.println(evalPrefix(tokens));
		//System.out.println(evaluatePrefix(tokens));
	}

}
