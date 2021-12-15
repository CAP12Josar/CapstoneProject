package gom.gbs.model;

public class User {

	private String userName;

	private String userPassword;

	private String creationDate;

	private int numberOfAccounts;

	private String listOfAccounts;

	private float totalBalance;

	private String contactNumber;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userPassword, String creationDate, int numberOfAccounts, String listOfAccounts,
			float totalBalance, String contactNumber) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.creationDate = creationDate;
		this.numberOfAccounts = numberOfAccounts;
		this.listOfAccounts = listOfAccounts;
		this.totalBalance = totalBalance;
		this.contactNumber = contactNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public void setNumberOfAccounts(int numberOfAccounts) {
		this.numberOfAccounts = numberOfAccounts;
	}

	public String getListOfAccounts() {
		return listOfAccounts;
	}

	public void setListOfAccounts(String listOfAccounts) {
		this.listOfAccounts = listOfAccounts;
	}

	public float getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(float totalBalance) {
		this.totalBalance = totalBalance;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
