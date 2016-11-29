package it.uniba.tdd;

public class StringCalculator {
	//default regex
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
		
		if( ! isValidFormat( numbersStr ) ){
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

	/**
	 * 
	 * @param numbersStr
	 * @return false if the string has an invalid format
	 * @throws StringCalculatorException
	 */
	public boolean isValidFormat( String numbersStr ) throws StringCalculatorException{
		//default regex cant be concat
		if( numbersStr.contains( REGEX[0]+REGEX[1] ) || numbersStr.contains( REGEX[1]+REGEX[0] ) ){
			return false;
		}
		//invlaid format different delimeter
		if( numbersStr.length() >= 4  && numbersStr.charAt(0) == '/' && numbersStr.charAt(1) == '/' && numbersStr.charAt(3) != '\n' ){
			return false;
		}
		//invalid format different delimiter
		if( numbersStr.length() >= 2 && numbersStr.length() < 4 && numbersStr.charAt(0) == '/' && numbersStr.charAt(1) == '/' ){
			return false;
		}
		//no negative numbers allowed
		if( numbersStr.contains( "-" ) ){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param numbersStr
	 * @param regex
	 * @return sum of string numbers with default regexp
	 */
	public int getSum( String numbersStr, String[] regex ){
		int result = 0;

		String[] numbers = numbersStr.split( regex[0] );
		
		for( String number : numbers ){
			result += getSum( number, regex[ 1 ] );
		}

		return result;
	}
	
	/**
	 * 
	 * @param numberStr
	 * @param regex
	 * @return sum of string numbers with single regexp
	 */
	public int getSum( String numberStr, String regex ){
		int result = 0;
		
		String[] numbers = numberStr.split(regex);
		
		for( String number : numbers ){
			int n = Integer.parseInt(number);
			if( n <= 1000 ){
				result += n;
			}
		}
		
		return result;
	}
	
	

}