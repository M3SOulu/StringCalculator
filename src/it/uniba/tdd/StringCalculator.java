package it.uniba.tdd;

public class StringCalculator {

	public int add(String numbersStr) throws StringCalculatorException {
		int sum = 0;
		char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		if (numbersStr.length() == 0) {
			sum = 0;
		} else if (numbersStr.length() == 1) {
			if (numbersStr.charAt(0) == '-'){
				throw new StringCalculatorException();
			}
			sum = Integer.parseInt(numbersStr);
		} else if (numbersStr.length() > 1) {
			if (numbersStr.charAt(0) == '-'){
				throw new StringCalculatorException();
			}
			for (int i = 0; i < numbersStr.length(); i++) {
				char a = numbersStr.charAt(i);
				for (int j = 0; j < numbers.length; j++) {
					if (a == numbers[j]) {
						String b = String.valueOf(a);
						sum += Integer.parseInt(b);
					}
				}
			}
		}
		return sum;
	}
}