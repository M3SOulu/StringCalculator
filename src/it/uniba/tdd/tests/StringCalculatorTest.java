package it.uniba.tdd.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniba.tdd.StringCalculator;
import it.uniba.tdd.StringCalculatorException;

public class StringCalculatorTest {
	public StringCalculator s;
	
	@Before
	public void setUp(){
		s = new StringCalculator();
	}
	
	@Test
	public void stringCalculatorNullString() throws StringCalculatorException {
		assertEquals(0, s.add( null ));
	}
	
	@Test
	public void stringCalculatorEmptyString() throws StringCalculatorException {
		assertEquals(0, s.add( "" ));
	}
	
	@Test
	public void stringCalculatorSingleNumberString() throws StringCalculatorException {
		assertEquals(1, s.add( "1" ));
	}
	
	@Test
	public void stringCalculatorDoubleNumberString() throws StringCalculatorException {
		assertEquals(3, s.add( "1,2" ));
	}
	
	@Test
	public void stringCalculatorDoubleRegexInString() throws StringCalculatorException {
		assertEquals(6, s.add( "1\n2,3" ));
	}
	
	@Test(expected = StringCalculatorException.class)
	public void stringCalculatorDoubleRegexInvalid() throws StringCalculatorException {
		s.add( "1\n," );
	}
	
	@Test
	public void stringCalculatorDifferentDelimiter1() throws StringCalculatorException {
		assertEquals(3, s.add("//;\n1;2"));
	}
	
	@Test
	public void stringCalculatorDifferentDelimiter2() throws StringCalculatorException {
		assertEquals(7, s.add("//-\n1-2-4"));
	}
	

	
	@Test(expected = StringCalculatorException.class)
	public void stringCalculatorDifferentDelimiterInvalidFormat() throws StringCalculatorException {
		assertEquals(7, s.add("//-1-2-4"));
	}
	

}
