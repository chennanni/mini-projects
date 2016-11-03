package app.atm;

public abstract class Account {
	protected String accountNumber;
	protected String accountType;
	protected float balance;
	protected boolean islockedFlag;
	
	public abstract int deposit(float money);
	public abstract int withdraw(float money);
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
