package it.uniba.tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int add(String numbersStr) throws NumberFormatException, StringCalculatorException {
		int tot=0;
		
		Pattern pattern=Pattern.compile("\\d+");
		Matcher matc=pattern.matcher(numbersStr);
		
		while(matc.find()){
			if(isValid(numbersStr)&&Integer.parseInt(matc.group())<=1000)
				tot+=Integer.parseInt(matc.group());
		}
		
		return tot;

	}

	public boolean isValid(String str) throws StringCalculatorException {
		
		Pattern pattern=Pattern.compile("-\\d+");
		Matcher matc=pattern.matcher(str);
		
		while(matc.find()){
			throw new StringCalculatorException();
		}
		
		
		return (!(str.length()==0)&&!str.endsWith("\\n"));
	}

}