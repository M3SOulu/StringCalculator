package it.uniba.tdd;
public class StringCalculatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StringCalculatorException(){
		
		super("negative number detected!!");
	}
}