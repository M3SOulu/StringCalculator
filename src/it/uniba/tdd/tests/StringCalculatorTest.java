package it.uniba.tdd.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniba.tdd.StringCalculator;
import it.uniba.tdd.StringCalculatorException;

public class StringCalculatorTest {
	
	private StringCalculator calc=new StringCalculator();;

	@Test
	public void testFirstTask() throws StringCalculatorException{
		
		assertEquals(0,calc.add(""));
		assertEquals(1,calc.add("1"));
		assertEquals(3,calc.add("1,2"));
		
	}
	
	@Test
	public void testSecondTask() throws StringCalculatorException{
		
		assertEquals(115,calc.add("112'3"));
	}
	
	@Test
	public void testThirdTask() throws StringCalculatorException{
		
		assertEquals(6,calc.add("1\n2,3"));
		assertEquals(0,calc.add("1,\n"));

	}
	
	public void testFourthTask() throws StringCalculatorException{
		
		assertEquals(3,calc.add("//;\n1;2"));

	}
	
	@Test(expected=StringCalculatorException.class)
	public void testFifthTask() throws StringCalculatorException{
		
		calc.add("//;\n1;-2");

	}
	
	@Test
	public void testSixthTask() throws StringCalculatorException{
		
		assertEquals(1004,calc.add("1\n1000,3"));
		assertEquals(4,calc.add("1\n1001,3"));

	}
	
	@Test
	public void testSeventhTask() throws StringCalculatorException{
		
		assertEquals(6,calc.add("//[***]\n1***2***3"));

	}
	
	@Test
	public void testEightTask() throws StringCalculatorException{
		
		assertEquals(6,calc.add("//[*][%]\n1*2%3"));

	}
	
	@Test
	public void testNinthTask() throws StringCalculatorException{
		
		assertEquals(6,calc.add("//[**][%%%]\n1**2%%%3"));

	}
}
