package it.uniba.tdd.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import it.uniba.tdd.StringCalculator;
import it.uniba.tdd.StringCalculatorException;


public class StringCalculatorTest {

	StringCalculator str;
	
	@Before
	public void setUp() {
		str = new StringCalculator();
	}
	
	@Test
	public void emptyString() throws NumberFormatException, StringCalculatorException {
		Assert.assertEquals(0, str.add(""));
	}
	
	@Test
	public void oneDigitString() throws NumberFormatException, StringCalculatorException {
		Assert.assertEquals(5, str.add("5"));
	}
	
	@Test
	public void twoDigitString() throws NumberFormatException, StringCalculatorException {
		Assert.assertEquals(8, str.add("5,3"));
	}
	
	@Test
	public void moreDigitsString() throws NumberFormatException, StringCalculatorException {
		Assert.assertEquals(10, str.add("5,3,2"));
		Assert.assertEquals(13, str.add("5,3,3,2"));
		Assert.assertEquals(15, str.add("5,3,3,2,2"));
		Assert.assertEquals(21, str.add("5,3,2,5,3,3"));
		
	}
	
	@Test
	public void spCharString() throws NumberFormatException, StringCalculatorException {
		Assert.assertEquals(10, str.add("5!,%3,2/"));
		Assert.assertEquals(6, str.add("//[\\*][%]\\n1\\*2%3"));
		Assert.assertEquals(2, str.add("1001,2"));
		Assert.assertFalse(str.isValid("65,gyy-grug9rfy4..ff\\n"));
		Assert.assertEquals(6, str.add("â€œ1\n2,3â€"));
		
	}
	
	@Test (expected=StringCalculatorException.class)
	public void delimiterCharString() throws NumberFormatException, StringCalculatorException {
		str.add("//;\n-1;2");
		
	}

}
