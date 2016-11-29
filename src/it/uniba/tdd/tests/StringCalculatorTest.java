package it.uniba.tdd.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import it.uniba.tdd.StringCalculator;


public class StringCalculatorTest {

	StringCalculator str;
	
	@Before
	public void setUp() {
		str = new StringCalculator();
	}
	
	@Test
	public void emptyString() {
		Assert.assertEquals(0, str.add(""));
	}
	
	@Test
	public void oneDigitString() {
		Assert.assertEquals(5, str.add("5"));
	}
	
	@Test
	public void twoDigitString() {
		Assert.assertEquals(8, str.add("5,3"));
	}
	
	@Test
	public void moreDigitsString() {
		Assert.assertEquals(10, str.add("5,3,2"));
		Assert.assertEquals(13, str.add("5,3,3,2"));
		Assert.assertEquals(15, str.add("5,3,3,2,2"));
		Assert.assertEquals(21, str.add("5,3,2,5,3,3"));
		
	}
	
	@Test
	public void spCharString() {
		Assert.assertEquals(10, str.addSpecialChar("5!,%3,2/"));
		Assert.assertEquals(13, str.addSpecialChar("5%,3/&,3/,2"));
		Assert.assertEquals(15, str.addSpecialChar("5:,3,;,3,2)),2"));
		Assert.assertEquals(21, str.addSpecialChar("5£)=,3,2$,$5,%3%3"));
		Assert.assertEquals(6, str.addSpecialChar("â€œ1\n2,3â€"));
		
	}
	
	@Test
	public void delimiterCharString() {
		Assert.assertEquals(3, str.addDiffDelimiters("//;\n1;2"));
		
	}

}
