package mortgage_Calculator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;


public class MortgageCalculator_FileIO_version {
	public static void main(String[] args) throws IOException {
		info();
		fileRead();
	}
	
	public static void info() {
		System.out.println("Here, we work with file txt, and we take the first 3 number, which represent the following sequential values:\n");
		wait(1000);
		System.out.println("Principal loaning ammount (int, between $1,000 and $1,000,000)");
		System.out.println("Annual interest rate (float, cannot be 0 or lower, up to 30%)");
		System.out.println("Number of years of loaning term (int, between 1 and 30)");
		wait(1000);
	}
	
	public static void fileRead() throws IOException {
		System.out.println("\nplease choose a file txt..."
				+ "\nAlso ensure it has all numbers needed for Mortgage calculator and not mixed with other char"
				+ "\nAlso separate them with \",\"");
		String filePath = fileSelect();
		System.out.println("\nchosen file and path:\n" + filePath);
		if (!filePath.contains(".txt")) {
			System.out.println("File chosen is not txt. program end");
			return;
		}
		
		//finding number in text file
		System.out.println("File chosen is a txt. Now reading file data...");
		wait(2000);
		BufferedReader read = new BufferedReader(new FileReader(filePath));
		String readResult; String targetString = "";
		while ((readResult = read.readLine()) != null) {
			targetString += readResult;
		}
		read.close();
		
		//separating words of targetString into array of 3 numbers
		 int count = 0;
		String arr[] = targetString.split("[,\\s]+");
		System.out.println("THe first 3 data for calculation:");
		for (String i : arr) {
			System.out.println(i);
			count++;
			if (count == 3) {break;}
		}
		wait(500);
		//setting values
		String field[] = {"Principal loaning ammount", "Annual Inerest rate", "Number of years of loaning term"};
		int a = 0; 	float b = 0;  int c = 0;
		if (0 < arr.length) {
			a = parsingInt(arr[0], field[0]);
		}
		
		if (1 < arr.length) {
			b = parsingFloat(arr[1], field[1]);
		}
		
		if (2 < arr.length) {
			c = parsingInt(arr[2], field[2]);
		}
		if (a==0||b==0||c==0) {
			System.out.print("\nCannot calculate mortgage due to a variable's value is 0"
					+ "\nPlease edit the file and bootup this program again");
		}
		mortgageCalculate(a, b, c);
	}

	public static void mortgageCalculate(int a, float b, int c) {
		Loan s = new Loan(a, b, c);
		System.out.printf("Total monthly mortgage payment: $%.2f", 
				s.calculateLoan());
	}
	
	
	
	public static int parsingInt(String i, String field) {
		try {
			int n = Integer.parseInt(i);
			return n;
		} catch (Exception e) {
			System.out.printf("Data %s is not usable for >>> %s <<< due to incorrect fomatting"
					+ "\nSetting default >>> %s <<< to 0",i,field,field);
			return 0;
		}
	}
	
	public static float parsingFloat(String i, String field) {
		try {
			float n = Float.parseFloat(i);
			return n;
		} catch (Exception e) {
			System.out.printf("Data %s is not usable for > %s < due to incorrect fomatting"
					+ "\nSetting default > %s < to 0",i,field,field);
			return 0;
		}
	}
	
	public static String fileSelect() {
		String filePath = "No file taken";
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		int result = chooser.showOpenDialog(chooser);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			filePath = selectedFile.getAbsolutePath();
		}
		return filePath;
	}
	
	public static void wait(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
