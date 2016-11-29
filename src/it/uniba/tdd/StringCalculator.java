package it.uniba.tdd;

public class StringCalculator {
	private static final String[] REGEX = { "\n", "," };

	
	/**
	 * Returns the sum of the numbers given in numbersStr
	 * @param numbersStr
	 * @return
	 * @throws StringCalculatorException 
	 */
	public int add(String numbersStr) throws StringCalculatorException {
		if( numbersStr == null || numbersStr.isEmpty() ){
			return 0;
		}
		
		if( numbersStr.contains( REGEX[0]+REGEX[1] ) || numbersStr.contains( REGEX[1]+REGEX[0] ) ){
			throw new StringCalculatorException();
		}
		
		if( numbersStr.charAt(0) == '/' && numbersStr.charAt(1) == '/' && numbersStr.charAt(3) != '\n' ){
			throw new StringCalculatorException();
		}
		
		int result;
		
		if( numbersStr.charAt(0) == '/' && numbersStr.charAt(1) == '/' ){
			result = getSum(  numbersStr.substring(4, numbersStr.length()), numbersStr.charAt(2) + "" );
		}
		else{
			result = getSum( numbersStr, REGEX );
		}
		
		return result;
	}

	
	public int getSum( String numbersStr, String[] regex ){
		int result = 0;

		String[] numbers = numbersStr.split( regex[0] );
		for( String number : numbers ){
			
			String[] num = number.split( regex[1] );
			for( String n : num )
				result += Integer.parseInt( n );
			
		}

		return result;
	}
	
	
	public int getSum( String numberStr, String regex ){
		int result = 0;
		
		String[] numbers = numberStr.split(regex);
		for( String number : numbers ){
			result += Integer.parseInt(number);
		}
		
		return result;
	}
	
	

}