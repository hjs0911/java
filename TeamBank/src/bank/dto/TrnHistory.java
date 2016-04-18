package bank.dto;

public class TrnHistory {
	
	private String empCode,accountnumber, trntype, trndate, trnmoney, balance;
	
	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getTrntype() {
		return trntype;
	}

	public void setTrntype(String trntype) {
		this.trntype = trntype;
	}

	public String getTrndate() {
		return trndate;
	}

	public void setTrndate(String trndate) {
		this.trndate = trndate;
	}

	public String getTrnmoney() {
		return trnmoney;
	}

	public void setTrnmoney(String trnmoney) {
		this.trnmoney = trnmoney;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

}
