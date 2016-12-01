package it.uniba.tdd;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	//default regex
	private static List<String> REGEX;
		
	public StringCalculator(){
		REGEX = new ArrayList<>();
		REGEX.add("\n");
		REGEX.add(",");
	}
	
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
		
		int result = 0;
		
		int occurencesNumber = getOccurencesNumber(numbersStr, '[');
		
		if( isAnyLengthDelimiter(numbersStr) && occurencesNumber == 2 ){
			//multiple delimiters of any lenght
			result = getSum(getStringWithoutDelimiter(numbersStr), getDelimiters(numbersStr));
		}
		else if( isAnyLengthDelimiter(numbersStr) && occurencesNumber == 1 ){
			//single delimiter of any lenght
			result = getSum( getStringWithoutDelimiter( numbersStr ), getDelimiters( numbersStr ).get(0));
		}
		else if( isSingleDifferentDelimiter( numbersStr ) ){
			//different delimiter
			result = getSum( numbersStr.substring(4), numbersStr.charAt(2) + "" );
		}
		else{
			result = getSum( numbersStr, REGEX );
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private boolean isAnyLengthDelimiter( String str ){
		if( str.length() < 3 )
			return false;
		if(!(str.charAt(0) == '/'))
			return false;
		if(!(str.charAt(1) == '/'))
			return false;
		if(!(str.charAt(2) == '['))
			return false;
		
		return true;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private boolean isSingleDifferentDelimiter( String str ){
		if( str.length() < 4 )
			return false;
		if(!(str.charAt(0) == '/'))
			return false;
		if(!(str.charAt(1) == '/'))
			return false;
		if(!(str.charAt(3) == '\n'))
			return false;
		
		return true;
	}
	
	
	
	/**
	 * 
	 * @param str
	 * @return delimiters of a string
	 */
	private List<String> getDelimiters( String str ){
		List<String> delimiters = new ArrayList<>();
		String subString = str;
		
		while( subString.indexOf('[') != -1 ){
			int beginIndex = subString.indexOf('[');
			int lastIndex = subString.indexOf(']');
			delimiters.add( subString.substring(beginIndex+1, lastIndex) );
			
			subString = subString.substring(lastIndex+1);
		}
		
		return delimiters;
	}
	
	/**
	 * 
	 * @param str
	 * @return the string without delimiters
	 */
	private String getStringWithoutDelimiter( String str ){
		int lastIndex = 0;
		String subString = str;
		
		while( subString.indexOf(']') != -1 ){
			lastIndex = subString.indexOf(']');
			subString = subString.substring(lastIndex+1);
		}
		
		return subString.substring( 1 );	//delete \n from string
	}

	/**
	 * 
	 * @param numbersStr
	 * @return false if the string has an invalid format
	 * @throws StringCalculatorException
	 */
	private boolean isValidFormat( String numbersStr ) throws StringCalculatorException{
		//default regex cant be concat
		if( numbersStr.contains( REGEX.get(0)+REGEX.get(1) ) || numbersStr.contains( REGEX.get(1)+REGEX.get(0) ) ){
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
	 * @return sum of string numbers with double regexp
	 */
	private int getSum( String numbersStr, List<String> regex ){
		if( regex == null || regex.size() < 2 ){
			return 0;
		}
		
		int result = 0;

		String[] numbers = numbersStr.split( regex.get(0) );
		
		for( String number : numbers ){
			result += getSum( number, regex.get(1) );
		}

		return result;
	}
	
	/**
	 * 
	 * @param numberStr
	 * @param regex
	 * @return sum of string numbers with single regexp
	 */
	private int getSum( String numberStr, String regex ){
		int result = 0;
		
		String[] numbers = numberStr.split(regex);
		
		for( String number : numbers ){
			int n = Integer.parseInt(number);
			if( n <= 1000 ){	//Numbers bigger than 1000 are ignored
				result += n;
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param str
	 * @param c
	 * @return the number that c occures in str
	 */
	private int getOccurencesNumber( String str, char c ){
		int n = 0;
		for( int i = 0; i < str.length(); i++ ){
			if( str.charAt( i ) == c ){
				n++;
			}
		}
		
		return n;
	}
	

}