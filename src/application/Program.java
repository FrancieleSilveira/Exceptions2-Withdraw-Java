package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double initialDeposit = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, initialDeposit, withdrawLimit);
		
		System.out.print("\nEnter amount for withdraw: ");
		Double amount = sc.nextDouble();
		
		account.withdraw(amount);
		
		System.out.print("New balance: " + account.getBalance());
		
		sc.close();
	}

}
