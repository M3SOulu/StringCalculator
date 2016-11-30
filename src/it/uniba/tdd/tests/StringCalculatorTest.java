package it.uniba.tdd.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.uniba.tdd.StringCalculator;
import it.uniba.tdd.StringCalculatorException;

public class StringCalculatorTest {

	public StringCalculator str;

	@Before
	public void initialize() {
		str = new StringCalculator();
	}

	@Test
	public void testVoidString() throws StringCalculatorException {
		Assert.assertEquals(0, str.add(""));
	}

	@Test
	public void testOneNumberString() throws StringCalculatorException {
		Assert.assertEquals(3, str.add("3"));
	}
	
	@Test
	public void testTwoNumberString() throws StringCalculatorException {
		Assert.assertEquals(3, str.add("3,0"));
	}

	@Test
	public void testFiveNumberString() throws StringCalculatorException {
		Assert.assertEquals(9, str.add("3,2,1,3,0"));
	}

	@Test
	public void testSupportDifferentDelimiters() throws StringCalculatorException {
		Assert.assertEquals(6, str.add("1\n2,3"));
		Assert.assertEquals(6, str.add("//[***]\n1***2***3"));
		Assert.assertEquals(6, str.add("//[*][%]\n1*2%3"));
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testException() throws StringCalculatorException{
		str.add("-");
	}
}