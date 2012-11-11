package creditcard;



/**
 * @author sanniv
 *
 */
public class LuhnAlgorithm {
	
	public int getCheckDigit(String aNumber)
	{
		return getCheckDigit(aNumber,false);
	}
	
	private int getCheckDigit(String aNumber,boolean checkDigitIncluded)
	{
		String inputNumber = validateNumber(aNumber,checkDigitIncluded);
		int totalSum = 0;
		boolean positionSwitch = true;
		int tempDigit;
		for(int i=inputNumber.length()-1;i>=0;i--)
		{
			if (!Character.isDigit(inputNumber.charAt(i))) {
				throw new RuntimeException(
						"The Input Number must be a valid Number");
			}
			tempDigit = Character.digit(inputNumber.charAt(i),10);
			if(positionSwitch)
				totalSum+= getSumForDoublerDigit(tempDigit);
			else
				totalSum+= tempDigit;
			positionSwitch=!positionSwitch;
		}		
		return (totalSum*9)%10;
	}
	
	private boolean validateCheckDigit(String aNumber,boolean checkDigitIncluded)
	{
		int resultCheckDigit = getCheckDigit(aNumber,checkDigitIncluded);
		if(resultCheckDigit == checkDigit)
			return true;
		return false;
	}
	
	public boolean validateCheckDigit(String aNumber,int checkDigit)
	{
		this.checkDigit = checkDigit;
		return validateCheckDigit(aNumber, false);
	}
	
	public boolean validateCheckDigit(String aNumber)
	{
		return validateCheckDigit(aNumber, true);
	}
	
	public static int getSumForDoublerDigit(int digit)
	{
		switch(digit)
		{		
		case 5:
			return 1;
		case 6:
			return 3;
		case 7:
			return 5;
		case 8:
			return 7;
		case 9:
			return 9;
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			return digit << 1;
		}
		
		return -1;
	}

	private int checkDigit;
	
	/**
	 * Validates Whether the supplied string is a valid number or not and also
	 * normalizes the input. If the supplied input is a negative number then it
	 * returns its positive. Only Decimal Number are supported.
	 * 
	 * @param inputNumber
	 * @return Normalized String if input is valid returns false if it is
	 *         invalid
	 * @throws NumberFormatException
	 */	
	private String validateNumber(String inputNumber, boolean checkDigitIncluded) {
		// Check whether string starts with a Minus '-' ('\u002D')
		if (inputNumber == null || inputNumber.trim().length() == 0) {
			throw new RuntimeException(
					"The Input Number must be a valid Number");
		}

		inputNumber = inputNumber.trim();

		if (inputNumber.startsWith("\u002D")) {
			if (inputNumber.length() == 1) {
				throw new RuntimeException(
						"The Input Number must be a valid Number");
			}
			inputNumber = inputNumber.substring(1);
		}

		if (checkDigitIncluded) {
			if (inputNumber.length() == 1)
				throw new RuntimeException(
						"The Input Number must be a valid Number");
			else {
				char checkCharacter = inputNumber
						.charAt(inputNumber.length() - 1);
				if (!Character.isDigit(checkCharacter)) {
					throw new RuntimeException(
							"The Input Number must be a valid Number");
				}
				checkDigit = Character.digit(checkCharacter, 10);
				inputNumber = inputNumber
						.substring(0, inputNumber.length() - 1);
			}
		}
		return inputNumber;

	}
	

}
