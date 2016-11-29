package it.uniba.tdd;

public class StringCalculator {

	public int add(String numbersStr) {
		String[] str=null;
		
		if (numbersStr.length() == 0) {
			return 0;
		}

		if (numbersStr.length() == 1) {
			return Integer.parseInt(numbersStr);
		}

		if (numbersStr.length() == 3) {
			return Integer.parseInt(numbersStr.substring(0, 1)) + Integer.parseInt(numbersStr.substring(2, 3));
		} else {
			int tot = 0;
			str=numbersStr.split(",");
			for(String st:str)
				tot=tot+Integer.parseInt(st);
			return tot;
		}

	}

	public int addSpecialChar(String numbersStr) {
		int tot = 0;

		for (int i = 0; i < numbersStr.length(); i++) {
			if (isNumber(numbersStr.charAt(i))) {
				tot = tot + Integer.parseInt(numbersStr.substring(i, i + 1));
			}
		}

		return tot;
	}

	private boolean isNumber(char ciar) {
		if (ciar == '1' || ciar == '2' || ciar == '3' || ciar == '4' || ciar == '5' || ciar == '6' || ciar == '7'
				|| ciar == '8' || ciar == '9' || ciar == '0')
			return true;

		return false;
	}

	public int addDiffDelimiters(String numbersStr){
		int tot=0;
		char delimiter=numbersStr.charAt(2);
		String[] numbs=null;
		
		numbs=numbersStr.split(String.valueOf(delimiter));
		
		for(String str:numbs){
			for(int i=0;i<str.length();i++){
				if(isNumber(str.charAt(i)))
					tot=tot+Integer.parseInt(str.substring(i, i + 1));
			}
			
			
			
			//tot=tot+Integer.parseInt(str);
		}
		
		return tot;
		
	}
}