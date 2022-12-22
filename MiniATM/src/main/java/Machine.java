import java.util.Scanner;

public class Machine {
	public static void main(String args[]) {
		
		int state = 0;
		// 0 - start
		// 1 - end
		// 2 - check pin
		// 3 - select accounts
		// 4 - account function
		// 5 - transaction success
		// 6 - transaction fail
		int txnState = 0;
		// 1 - deposit successful
		// 2 - withdraw successful
		// 3 - deposit maximum alert
		// 4 - account lock
		// 5 - withdraw exceeds balance
		
		// data set up
		Account selectedAccount = null;
		Account checkingAccount = new CheckingAccount("001001001", (float) 5468.25);
		Account savingAccount = new SavingAccount("001001002", (float) 6800.00);
		User user = new User("123456", checkingAccount, savingAccount);
		
		// get the initial user input
		Scanner scanner = new Scanner(System.in);
		System.out.println("(PIN is 123456)");
		System.out.println("Please enter PIN or q to quit: ");
		String input = scanner.nextLine();
		if (input.equalsIgnoreCase("q")) {
			state = 1;
		} else {
			state = 2;
		}
		
		// keep running the atm
		while (state != 1) {

			// state - check pin
			if (state == 2) {
				if (input.compareTo(user.getPin()) == 0) { // pin match
					System.out.println("Login successful.");
					state = 3;
				} else { // pin not match
					System.out.println("Please enter PIN or q to quit: ");
					input = scanner.nextLine();
					state = 2;
				}
			}

			// state - select accounts
			if (state == 3) { 
				
				System.out.println("*****************************************");
				System.out.println("Account Selection - Options:");
				System.out.println("1. Checking Account");
				System.out.println("2. Saving Account");
				System.out.println("Please select 1 or 2 or q to quit: ");
				input = scanner.nextLine();

				if (input.equalsIgnoreCase("q")) {
					state = 1;
				} else if (input.equalsIgnoreCase("1")) {
					selectedAccount = user.getCheckingAccount();
					state = 4;
				} else if (input.equalsIgnoreCase("2")) {
					selectedAccount = user.getSavingAccount();
					state = 4;
				} else {
					System.out.println("Error: selection is not correct.");
					state = 3;
				}
			}

			// state - account function
			if (state == 4) { 
				
				System.out.println("*****************************************");
				System.out.println("You are viewing: "+ selectedAccount.getAccountType());
				System.out.println("Account Number: "+ selectedAccount.getAccountNumber());
				System.out.println("Balance: " + selectedAccount.getBalance());
				
				System.out.println("Options:");
				System.out.println("1. Withdraw");
				System.out.println("2. Deposit");
				System.out.println("Please select 1 or 2 or b to back: ");
				input = scanner.nextLine();
				
				if (input.equalsIgnoreCase("b")) {
					state = 3;
				} else if (input.equalsIgnoreCase("1")) { // withdraw
					System.out.println("Please enter withdraw amount:");
					try {
						float inputNumber = scanner.nextFloat();
						scanner.nextLine(); // consume the nextline elements
						txnState = selectedAccount.withdraw(inputNumber);
						state = (txnState == 1 || txnState == 2 ? 5:6);
					} catch (Exception e) {
						System.out.println("Error: input number is not correct.");
						state = 4;
					}
				} else if (input.equalsIgnoreCase("2")) { // deposit
					System.out.println("Please enter deposit amount:");
					try {
						float inputNumber = scanner.nextFloat();
						scanner.nextLine(); // consume the nextline elements
						txnState = selectedAccount.deposit(inputNumber);
						state = (txnState == 1 || txnState == 2 ? 5:6);
					} catch (Exception e) {
						System.out.println("Error: input number is not correct.");
						state = 4;
					}
				} else {
					System.out.println("Error: input number is not correct.");
					state = 4;
				}
			}
			
			// state - transaction success
			if (state == 5) {
				System.out.println("*****************************************");
				System.out.println("Transaction successful.");
				System.out.println("Your new account balance: "+ selectedAccount.getBalance());
				state = 1;
			}

			// state - transaction fail
			if (state == 6) {
				
				System.out.println("*****************************************");
				System.out.println("Transaction fail.");
				
				if (txnState == 3) {
					System.out.println("Deposit amount exceeds maximan amount($10k). "
							+ "Please contact the bank manager to clear the deposit."
							+ "Until then, your accout will be locked.");
				} else if (txnState == 4) {
					System.out.println("Account is locked. "
							+ "Please contact the bank manager to unlock the account.");
				} else if (txnState == 5) {
					System.out.println("Withdraw exceeds balance amount.");
				}
				
				state = 4;
			}
		}
		
		System.out.println("Thanks for using this ATM.");
		
		scanner.close();
	}
}
