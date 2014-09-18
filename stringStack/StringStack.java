package stringStack;

public class StringStack {
	
	String[] stringArray = new String[50];
	int items = 0;
	
	public StringStack(){
		items = 0;		
	}
	
	public void push(String pushString){
		items = items+1;
		stringArray[items] = pushString;
	}
	
	public String pop(){
		String result = stringArray[items];
		items = items-1;
		return result;
	}
	
	public boolean stackIsEmpty(){
		boolean result = false;
		if (items == 0){
			result = true;
		}
		return result;
	}
	
	public boolean stackIsFull(){
		boolean result = false;
		if (items == 50){
			result = true;
		}
		return result;
	}
	
	public void emptyStack(){
		items = 0;
	}
	
	
}
