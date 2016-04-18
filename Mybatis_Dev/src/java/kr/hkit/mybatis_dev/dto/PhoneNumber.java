package kr.hkit.mybatis_dev.dto;

public class PhoneNumber {
	//010-0111-0000 countryCone - stateCode - number
	private String countryCode, stateCode, number;

	private PhoneNumber() {
	}

	private PhoneNumber(String countryCode, String stateCode, String number) {
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.number = number;
	}
	
	public PhoneNumber(String str){
		if(str != null){
			String[] parts = str.split("-");
			if(parts.length > 0) this.countryCode = parts[0];
			if(parts.length > 1) this.stateCode = parts[1];
			if(parts.length > 2) this.number = parts[2];
		}
	}
	
	

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format("%s-%s-%s", countryCode, stateCode, number);
	}

	
	
	
}
