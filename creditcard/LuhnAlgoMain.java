package creditcard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuhnAlgoMain
{
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	private static final int MIN_CHOICE = 1;
	private static final int MAX_CHOICE = 5;
	public static void main(String[] args) throws IOException {
		
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		LuhnAlgorithm processor = new LuhnAlgorithm();
		int choice;
		while(true)
		{
			printMenu();
			try {
				choice = Integer.parseInt(inputReader.readLine());
				if(choice<MIN_CHOICE || choice>MAX_CHOICE)
				{
					System.out.println("---Warning--Invalid Choice.Try Again");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("---Warning--Invalid Choice.Try Again");
				continue;
			}
			int checkDigit;
			boolean result;
			try {
				switch(choice)
				{
				case 1:
					System.out.print("Enter the Number : ");
					checkDigit = processor.getCheckDigit(inputReader.readLine());
					System.out.println("The Check Digit is "+checkDigit);
					break;
				case 2:
					System.out.print("Enter the Check Digit : ");
					try {
						checkDigit = Integer.parseInt(inputReader.readLine());
						if(checkDigit<0 || checkDigit>9)
						{
							System.out.println("---Warning--Invalid Check Digit.Try Again");
							continue;
						}
					} catch (NumberFormatException e) {
						System.out.println("---Warning--Invalid Check Digit.Try Again");
						continue;
					}
					System.out.print("Enter the Number : ");
					result = processor.validateCheckDigit(inputReader.readLine(),checkDigit);
					if(result)
						System.out.println("\u2713\u2713\u2713\u2713 Valid Check Digit \u2713\u2713\u2713\u2713");
					else
						System.out.println("\u274C\u274C\u274C\u274C Invalid Check Digit \u274C\u274C\u274C\u274C");	
					break;				
				case 3:
					System.out.print("Enter the Number : ");
					result = processor.validateCheckDigit(inputReader.readLine());
					if(result)
						System.out.println("\u2713\u2713\u2713\u2713 Valid Check Digit \u2713\u2713\u2713\u2713");
					else
						System.out.println("\u274C\u274C\u274C\u274C Invalid Check Digit \u274C\u274C\u274C\u274C");
					break;
				case 4:
					help();
					break;
				case 5:
					System.out.println("\u1F3E\u1F3E\u1F3E\u1F3E Thanks for using Luhn Algorithm \u1F3E\u1F3E\u1F3E\u1F3E");
					return;
				}
			} catch (RuntimeException e) {
				System.out.println("---Warning--"+e.getMessage());				
			}
		}

	}
	
	private static void printMenu()
	{
		System.out.println();
		System.out.println("--------------Luhn Algorithm Menu--------------");
		System.out.println("\t 1. Get Check Digit");
		System.out.println("\t 2. Verify Check Digit");
		System.out.println("\t 3. Verify Check Digit (included check digit in i/p)");
		System.out.println("\t 4. Algorithm Help");
		System.out.println("\t 5. Exit");
		System.out.print("\tEnter your Choice : ");
	}
	
	private static void help()
	{
		// FIXME Improve Help Text
		System.out.println("------------------------Luhn Algorithm------------------------------");
		System.out.println("The Luhn algorithm or Luhn formula, also known as the modulus 10 or ");
		System.out.println("mod 10 algorithm, is a simple checksum formula used to validate a variety ");
		System.out.println("of identification numbers, such as credit card numbers, IMEI numbers, ");
		System.out.println("National Provider Identifier numbers in US and Canadian Social Insurance Numbers. ");
		System.out.println("It was created by IBM scientist Hans Peter Luhn and described in U.S. Patent No. 2,950,048, ");
		System.out.println("filed on January 6, 1954, and granted on August 23, 1960.");
		System.out.println("-------------------------End Of Help--------------------------------");
	}

}
