package it.uniba.tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	public int add(String numbersStr) throws StringCalculatorException{
		
		int result=0;
		
		if(isValid(numbersStr)){
		
			Pattern pattern=Pattern.compile("\\d+");
			Matcher matcher= pattern.matcher(numbersStr);
			
			while(matcher.find()){
				
				int val=Integer.parseInt(matcher.group());
				
				if(val<=1000)				
						result+=val;
			}
		
		}
		
		return result;
	}
	
	private boolean isValid(String numbersStr) throws StringCalculatorException{
		
		Pattern pattern=Pattern.compile("-\\d+");
		Matcher matcher= pattern.matcher(numbersStr);
		
		if(matcher.find())
			throw new StringCalculatorException();
		
		return (numbersStr.length()!=0 && !numbersStr.endsWith("\n"));
	}
}