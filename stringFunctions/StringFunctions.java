package stringFunctions;

public class StringFunctions {
	
	public static boolean isNumber(String input){
		boolean result = true;
		
		int length = input.length();
		
		int index = 0;
		
		while (index < length){
			if (!Character.isDigit(input.toCharArray()[index]) & input.toCharArray()[index]!='.'){
				result = false;
			}
			index = index +1;
		}
		
		return result;
	}
	
	public static boolean hasDecimal(String input){
		boolean result = false;
		
		int length = input.length();
		
		int index = 0;
		
		while (index < length){
			if (input.toCharArray()[index]=='.'){
				result = true;
			}
			index = index +1;
		}
		
		return result;
	}
}
