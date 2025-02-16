package mortgage_Calculator;

import java.util.Scanner;

public class MortgageCalculate_console_version {
	public static int inputPrincipal_Loaning_Ammount(Scanner scan) {
		int n = 0; //for convenient naming
		System.out.println("Please enter ammount of principal loaning (between $1,000 and $1,000,000):");
		n = scan.nextInt();
		if (n < 1000 || n > 1000000) {
			System.out.println("The number is not in given range!!! Please try again!\n");
			inputPrincipal_Loaning_Ammount(scan);
		}
		return n;
	}
	
	public static float inputAnnual_Interest_Rate(Scanner scan) {
		float n = 0; 
		System.out.println("Please enter annual interest rate (up to 30%, but not 0 or lower):");
		n = Float.parseFloat(scan.next());
		if (n <= 0 || n > 30) {
			System.out.println("The number is not in given range!!! Please try again!\n");
			inputAnnual_Interest_Rate(scan);
		}
		return n;
	}
	
	public static int inputYearsOfLoaningTerm(Scanner scan) {
		int n = 0; 
		System.out.println("Please enter number of years of loaning term (between 1 and 30):");
		n = scan.nextInt();
		if (n < 1 || n > 30) {
			System.out.println("The number is not in given range!!! Please try again!\n");
			inputYearsOfLoaningTerm(scan);
		}
		return n;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int principal_Loaning_Ammount = inputPrincipal_Loaning_Ammount(scan);;
		float annual_Interest_Rate = inputAnnual_Interest_Rate(scan);
		int yearsOfLoaningTerm = inputYearsOfLoaningTerm(scan);
		
		Loan loan = new Loan(principal_Loaning_Ammount, annual_Interest_Rate, yearsOfLoaningTerm);
		System.out.printf("Total monthly mortgage payment: %.2f", 
				loan.calculateLoan());
		scan.close();

	}

}
