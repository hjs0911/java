package bank.dto;

public class Employee {
	private String empName;
	private String empAuth;
	private String empCode;
	private String empTitle;
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpTitle() {
		return empTitle;
	}
	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAuth() {
		return empAuth;
	}
	public void setEmpAuth(String empAuth) {
		this.empAuth = empAuth;
	}
}
