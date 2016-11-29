package it.uniba.tdd;

public class StringCalculator {

	public StringCalculator() {
		// TODO Auto-generated constructor stub
	}

	public int add(String numbersStr) throws StringCalculatorException {

		int sum = 0;
		String[] stringT;

		if (numbersStr.contains("\n")) {
			stringT = numbersStr.split("\n");

			if (stringT.length == 1)
				throw new StringCalculatorException();
			else {
				for (int i = 0; i < stringT.length; i++) {

					sum += numbersSeparatedToVirgola(stringT[i]);
				}
			}
		} else {

			sum += numbersSeparatedToVirgola(numbersStr);
		}

		return sum;
	}

	/**
	 * @param numbersStr
	 * @return sum
	 */
	private int numbersSeparatedToVirgola(String numbersStr) {
		int sum = 0;
		String[] stringTemp = null;

		if (numbersStr == "")
			sum = 0;

		else if (numbersStr.length() == 1)

			sum = Integer.valueOf(numbersStr);

		else {

			stringTemp = numbersStr.split(",");

			for (int i = 0; i < stringTemp.length; i++) {

				sum += Integer.valueOf(stringTemp[i]);

			}
		}

		return sum;
	}
}