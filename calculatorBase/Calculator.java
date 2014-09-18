package calculatorBase;

import stringStack.StringStack;
import stringFunctions.StringFunctions;

public class Calculator {

	String operationString;
	String resultString;
		
	StringStack calcStack = new StringStack();
	
	public Calculator (){
		this.operationString = "";
		this.resultString = "";
		calcStack.emptyStack();
	}
	
	public String getOperationString(){
		String result = "";
		result = this.operationString;
		return result;
	}
	
	public String getResultString(){
		String result = "";
		result = this.resultString;
		return result;
	}
	
	private boolean isOperator(String inputString){
		boolean result = false;
		
		if (inputString == "mul" | inputString == "div" | inputString == "add" | inputString == "sub"){
			result = true;
		}
		
		return result;
	}
	
	public void addOperation(String input){
		calcStack.push(input);
		if (StringFunctions.isNumber(input)){
			operationString = operationString+input;
		}
		else {
			if (input == "mul"){
				operationString = operationString+"*";
			}
			else if (input == "div"){
				operationString = operationString+"/";
			}
			else if (input == "add"){
				operationString = operationString+"+";
			}
			else if (input == "sub"){
				operationString = operationString+"-";
			}
		}
	}
	
	public void processStack(){
		String stringOne = "";
		String stringTwo = "";
		String stringThree = "";
		operationString = "";
		while (!calcStack.stackIsEmpty()){
			stringOne = calcStack.pop();
			if (StringFunctions.isNumber(stringOne)){
				if (calcStack.stackIsEmpty()){
					resultString = stringOne;
				}
				else {
					stringTwo = calcStack.pop();
					if (isOperator(stringTwo)){
						stringThree = calcStack.pop();
						if (StringFunctions.isNumber(stringThree)){
							if (stringTwo == "mul"){
								resultString = Float.toString(Float.parseFloat(stringThree)*Float.parseFloat(stringOne));
								calcStack.push(resultString);
							}
							else if (stringTwo == "div"){
								resultString = Float.toString(Float.parseFloat(stringThree)/Float.parseFloat(stringOne));
								calcStack.push(resultString);
							}
							else if (stringTwo == "add"){
								resultString = Float.toString(Float.parseFloat(stringThree)+Float.parseFloat(stringOne));
								calcStack.push(resultString);
							}
							else if (stringTwo == "sub"){
								resultString = Float.toString(Float.parseFloat(stringThree)-Float.parseFloat(stringOne));
								calcStack.push(resultString);
							}
						}
					}
				}
			}
		}
				
	}
}
