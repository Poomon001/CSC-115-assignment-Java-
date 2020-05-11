/**Poomrapee Chuthamsatid V00942601**/
/**9 March 2020**/
import java.math.BigInteger; 
// imported for you, so you can use BigInteger objects to detect integer over/underflows
// delete if you want to do this differently

public class RPNCalculator {
	private Stack<String> stack;
	private int size;
	
	public RPNCalculator (int initSize) {
// create a new object from StackArray class  
// and set the size field to the provided parameter initSize
		stack = new StackArray(initSize);
		size = initSize;
	}//constructor1
	
	public int calculate(String[] expression) throws CalculatorException {
		int result2 = 0;
		boolean isOperator = false;
		boolean isOperand = false;
		BigInteger result = null;
		//for testing purpose only
		for(int i = 0; i < expression.length; i++) {
			isOperator = isOperator(expression[i].toString());
			isOperand = isOperand(expression[i].toString());
			
				//if it is operator
				if(isOperator) {
					
					//try to calculate number
					try {	
						String	y = stack.pop();
						String x = stack.pop();
						
						//throw error if it is divided by 0
						if(expression[i]. equals("/") && y.equals("0")) {
							throw new CalculatorException("division by zero");
						}//if
						
						result = new BigInteger (compute(expression[i], x, y));
					//errors occur with the calculation process 
					}catch(CalculatorException e){
							throw new CalculatorException(e.getMessage());
					}catch (Exception e) {
						throw new CalculatorException("Invalid expression");
					}//catch
					
				//if it is operand
				}else if (isOperand) {
					
					//try to push operand into the stack
					try {
						stack.push(String.valueOf((expression[i])));
					} catch (StackException e) {
						growStack(expression[i], expression);
				   }//catch
				}else if (!(isOperand && isOperator)) {
					throw new CalculatorException("Invalid token");
				}//if
		}//for
		
		//try to pop result from the stack
		try {
		    result2 = Integer.parseInt(stack.pop());
		} catch (StackException e) {
			System.out.println("Your code threw an Exception.");
	        System.out.println("Perhaps a stack trace will help:");
	        e.printStackTrace(System.out);
	   }//catch
		return result2; // this line is only here to this compiles - replace with algorithm
	} //calculate
	
	// remember: you can define private helper methods. That improves code-readability
	// for example: we recommend that you define a private "compute" method that carries out
	// one primitive computation
	
	private String compute (String operator, String operand1, String operand2) throws CalculatorException {
		int num1 = Integer.parseInt(operand1);
		int num2 = Integer.parseInt(operand2);
		BigInteger bigN1 = new BigInteger(String.valueOf(num1));
		BigInteger bigN2 = new BigInteger(String.valueOf(num2));
		BigInteger bigNum2 = new BigInteger(String.valueOf(-2147483648));
		BigInteger bigNum3 = new BigInteger(String.valueOf(2147483647));
		BigInteger result = new BigInteger(String.valueOf(0));
		
		//calculate result
		switch (operator) {
			case "+":
				result = bigN1.add(bigN2);
				break;
			case "-":
				result = bigN1.subtract(bigN2);
				break;
			case "*":
				result = bigN1.multiply(bigN2);
				break;
			case "/":
				result = bigN1.divide(bigN2);
		}//switch
		
		//if result over or under
		if(result.compareTo(bigNum3) == 1) {
			throw new CalculatorException("integer overflow");
		}else if(result.compareTo(bigNum2) == -1) {
			throw new CalculatorException("integer underflow");
		}//if
		
		//try to push result
		try {
			stack.push(String.valueOf(result));
		} catch (StackException e) {
			// TODO Auto-generated catch block
			System.out.println("Your code threw an Exception.");
            System.out.println("Perhaps a stack trace will help:");
            e.printStackTrace(System.out);
		}//catch
		//System.out.println(String.valueOf(result));
		return String.valueOf(result); 
	}//compute
	
	//if s is one of operands
	private boolean isOperand (String s) {
		int d = 0;
		try {
	        d = Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	}//isOperator
	
	//if s is one of operators
	private boolean isOperator (String s) {
		return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
	}//isOperand
	
	private void growStack(String s, String []array) {
		Stack<String> twice = new StackArray(size*2);
		
		//create a copy of array
		String [] copy = new String [size];
		
		for(int x = 0; x < size; x++) {
			
			//store data from stack to copy (up side down)
			try {
				copy[x] = stack.pop();
			} catch (StackException e) {
				// TODO Auto-generated catch block
				 System.out.println("Your code threw an Exception." + e);
		         System.out.println("Perhaps a stack trace will help:");
		         e.printStackTrace(System.out);
			}
		}
		
		//push data to new stack (twice) backward (copy is currently up side down)
		for(int x = size-1; x >= 0; x--) {
			try {
				twice.push(copy[x]);
			} catch (StackException e) {
				// TODO Auto-generated catch block
				 System.out.println("Your code threw an Exception." + e);
		         System.out.println("Perhaps a stack trace will help:");
		         e.printStackTrace(System.out);
			}//catch
		
		}//for
		
		//puch new value to new stack (twice)
		try {
			twice.push(s);
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch

		//assign twuice to stack
		stack = twice;
		size *= 2;
		
	}//growStack
}//RPNCalculator