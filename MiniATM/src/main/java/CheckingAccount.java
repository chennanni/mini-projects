public class CheckingAccount extends Account{
	public CheckingAccount(String accountNumber, float balance) {
		super.accountNumber = accountNumber;
		super.balance = balance;
		super.accountType = "Checking Account";
		super.islockedFlag = false;
	}

	@Override
	public int deposit(float money) {
		if (!super.islockedFlag) {
			if (money >= 10000) {
				super.balance += money;
				super.islockedFlag = true;
				return 3; // deposit maximum alert
			} else {
				super.balance += money;
				return 1; // deposit successful
			}
		} else {
			return 4; // account lock
		}

	}

	@Override
	public int withdraw(float money) {
		if (!super.islockedFlag) {
			if (money <= super.balance) {
				super.balance -= money;
				return 2; // withdraw successful
			} else {
				return 5; // withdraw exceeds balance
			}
		} else {
			return 4; // account lock
		}
	}
}
