package app.atm;

public class User {
	private String pin;
	private Account checkingAccount;
	private Account savingAccount;
	
	public User(String pin, Account checkingAccount, Account savingAccount){
		this.pin = pin;
		this.checkingAccount = checkingAccount;
		this.savingAccount = savingAccount;
	}
	
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Account getCheckingAccount() {
		return checkingAccount;
	}
	public void setCheckingAccount(Account checkingAccount) {
		this.checkingAccount = checkingAccount;
	}
	public Account getSavingAccount() {
		return savingAccount;
	}
	public void setSavingAccount(Account savingAccount) {
		this.savingAccount = savingAccount;
	}
}
