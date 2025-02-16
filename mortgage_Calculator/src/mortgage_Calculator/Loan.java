package mortgage_Calculator;

public class Loan {
	private int principal_Loan;
	private float annual_Interest_Rate;
	private int yearsOfLoaningTerm;
	
	public Loan(int principal_Loan, float annual_Interest_Rate, int loaning_Term_Length) {
		this.principal_Loan = principal_Loan;
		this.annual_Interest_Rate = annual_Interest_Rate;
		this.yearsOfLoaningTerm = loaning_Term_Length;
	}
	
	public int getPrincipal_Loan() {
		return principal_Loan;
	}
	
	public void setPrincipal_Loan(int principal_Loan) {
		this.principal_Loan = principal_Loan;
	}
	
	public float getAnnual_Interest_Rate() {
		return annual_Interest_Rate;
	}
	
	public void setAnnual_Interest_Rate(float annual_Interest_Rate) {
		this.annual_Interest_Rate = annual_Interest_Rate;
	}
	
	public int getYearsOfLoaningTerm() {
		return yearsOfLoaningTerm;
	}
	
	public void setYearsOfLoaningTerm(int yearsOfLoaningTerm) {
		this.yearsOfLoaningTerm = yearsOfLoaningTerm;
	}
	
	public float calculateLoan() {
		/*   p is principal loaning amount
		 * only perform this function after a Loan variable is created with legit values
		 */
		int p = getPrincipal_Loan();
		float r = getAnnual_Interest_Rate() / 100 / 12; //Monthly interest rate
		int n = getYearsOfLoaningTerm() * 12; //Number of payment over loaning term
		float value1 = (float)r * (float)Math.pow(1+r, n);
		float value2 = (float)Math.pow(1+r, n) - 1;
		return p * value1 / value2;
	}
}
