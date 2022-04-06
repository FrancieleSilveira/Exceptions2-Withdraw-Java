package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialDeposit = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, initialDeposit, withdrawLimit);
			
			System.out.print("\nEnter amount for withdraw: ");
			Double amount = sc.nextDouble();
				
			
			account.withdraw(amount);
			
			System.out.printf("New balance: %.2f", account.getBalance());
		}
		catch (BusinessException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
			e.printStackTrace();
			sc.next();
		}
		
		sc.close();
	}

}
