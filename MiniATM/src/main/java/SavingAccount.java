public class SavingAccount extends Account{
	private float interest;
	private float penalty;
	
	public SavingAccount(String accountNumber, float balance) {
		super.accountNumber = accountNumber;
		super.balance = balance;
		super.accountType = "Saving Account";
		super.islockedFlag = false;
		this.interest = (float) 0.1;
		this.penalty = (float) 3.0;
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
				applyInterests();
				return 1; // deposit successful
			}
		} else {
			return 4; // account lock
		}
	}

	@Override
	public int withdraw(float money) {
		if (!super.islockedFlag) {
			if (money <= super.balance+this.penalty) {
				super.balance -= (money+this.penalty);
				applyPenalty();
				return 2; // withdraw successful
			} else {
				return 5; // withdraw exceeds balance
			}
		} else {
			return 4; // account lock
		}
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public float getPenalty() {
		return penalty;
	}

	public void setPenalty(float penalty) {
		this.penalty = penalty;
	}
	
	private void applyInterests() {
		System.out.println("Deposit to Saving Account generates "+this.interest + "% interests.");
	}
	
	private void applyPenalty() {
		System.out.println("Withdraw from Saving Account deducts $" + this.penalty + " from your account.");
	}
	
}
