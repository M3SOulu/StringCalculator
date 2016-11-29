package it.uniba.tdd.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniba.tdd.StringCalculator;
import it.uniba.tdd.StringCalculatorException;

public class StringCalculatorTest {
	
	StringCalculator calc;
	
	@Before
	public void SetUp(){
		calc = new StringCalculator();
		
	}

	@Test
	public void StringNull() throws StringCalculatorException {
		assertEquals(0, calc.add(""));
	}
	
	@Test
	public void StringOneNumber() throws StringCalculatorException {
		assertEquals(1, calc.add("1"));
	}
	
	@Test
	public void StringTwoNumber() throws StringCalculatorException {
		assertEquals(3, calc.add("1,2"));
	}
	
	@Test
	public void StringThreeNumber() throws StringCalculatorException {
		assertEquals(6, calc.add("1,2,3"));
	}
	
	@Test(expected = StringCalculatorException.class)
	public void StringOneNumberTwoLine() throws StringCalculatorException {
		calc.add("1\n");
	}
	
	@Test
	public void StringNumberTwoLine() throws StringCalculatorException {
		assertEquals(6, calc.add("1\n2,3"));
	}
	
	@Test
	public void StringNumberThreeLine() throws StringCalculatorException {
		assertEquals(11, calc.add("1\n2,3\n5"));
	}
	
	
	

}
