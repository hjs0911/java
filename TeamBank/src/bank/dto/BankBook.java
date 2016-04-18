package bank.dto;

public class BankBook {
	protected String accountnumber;
	protected String cltcode;
	protected String openingdate;
	protected String interestrate;
	protected String balance;
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getCltcode() {
		return cltcode;
	}
	public void setCltcode(String cltcode) {
		this.cltcode = cltcode;
	}
	public String getOpeningdate() {
		return openingdate;
	}
	public void setOpeningdate(String openingdate) {
		this.openingdate = openingdate;
	}
	public String getInterestrate() {
		return interestrate;
	}
	public void setInterestrate(String interestrate) {
		this.interestrate = interestrate;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	
}
