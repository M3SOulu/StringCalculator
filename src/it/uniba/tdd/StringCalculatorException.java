package it.uniba.tdd;

public class StringCalculatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	StringCalculatorException(){
		super();
	}
	
	StringCalculatorException(String err){
		System.err.println(err);
	}
}