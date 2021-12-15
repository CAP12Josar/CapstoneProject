package gom.gbs.model;


public class Transaction {
	

	private int transactionId;

	private int fromAccount;

	private int toAccount;

	private int accountBalance;
	public Transaction() {
	super();
	// TODO Auto-generated constructor stub
}
	public Transaction(int transactionId, int fromAccount, int toAccount, int accountBalance) {
		super();
		this.transactionId = transactionId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.accountBalance = accountBalance;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
}