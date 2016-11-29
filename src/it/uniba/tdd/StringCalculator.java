package it.uniba.tdd;

public class StringCalculator {
	private static final String REGEX1 = ",";
	private static final String REGEX2 = "\n";

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
		
		if( numbersStr.contains( REGEX1+REGEX2 ) || numbersStr.contains( REGEX2+REGEX1 ) ){
			throw new StringCalculatorException();
		}
		
		return getSum( numbersStr );
	}

	public int getSum( String numbersStr ){
		int result = 0;

		String[] numbers = numbersStr.split( REGEX2 );
		for( String number : numbers ){
			
			String[] num = number.split( REGEX1 );
			for( String n : num )
				result += Integer.parseInt( n );
			
		}

		return result;
	}
	
	

}