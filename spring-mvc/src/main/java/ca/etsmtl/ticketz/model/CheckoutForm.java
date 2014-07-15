package ca.etsmtl.ticketz.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CheckoutForm {
	
	// Step 1
	@NotNull
	private String lastName;
	@NotNull
	private String firstName;
	@NotNull
	private String address;
	@NotNull
	private String city;
	@Pattern(regexp = "\\w{2}")
	private String province;
	@Pattern(regexp = "\\w\\d\\w\\d\\w\\d")
	private String postalCode;
	@Pattern(regexp = "\\d{10,11}")
	private String telephone;
	
	
	// Step 2
	@NotNull
	private String ccLastName;
	@NotNull
	private String ccFirstName;
	@Pattern(regexp = "\\d{16}")
	private String ccNumber;
	@Pattern(regexp = "\\d{2}")
	private String ccMonth;
	@Pattern(regexp = "\\d{4}")
	private String ccYear;
	@Pattern(regexp = "\\d{3,4}")
	private String ccCVC;
	
	
	public CheckoutForm() { }
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCcLastName() {
		return ccLastName;
	}
	public void setCcLastName(String ccLastName) {
		this.ccLastName = ccLastName;
	}
	public String getCcFirstName() {
		return ccFirstName;
	}
	public void setCcFirstName(String ccFirstName) {
		this.ccFirstName = ccFirstName;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public String getCcMonth() {
		return ccMonth;
	}
	public void setCcMonth(String ccMonth) {
		this.ccMonth = ccMonth;
	}
	public String getCcYear() {
		return ccYear;
	}
	public void setCcYear(String ccYear) {
		this.ccYear = ccYear;
	}
	public String getCcCVC() {
		return ccCVC;
	}
	public void setCcCVC(String ccCVC) {
		this.ccCVC = ccCVC;
	}

}
