package ca.etsmtl.ticketz.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="lastName")
	private String lastName;
	@Column(name="firstName")
	private String firstName;
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="province")
	private String province;
	@Column(name="postalCode")
	private String postalCode;
	@Column(name="country")
	private String country;
	@Column(name="telephone")
	private String telephone;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="Client_CreditCard",
				joinColumns={@JoinColumn(name="c_id")},
				inverseJoinColumns={@JoinColumn(name="cc_id")})
	private CreditCard creditCard;
	
	
	public Client(String _lastName, String _firstName, String _address, String _city, String _province, String _country, String _postalCode, String _telephone, CreditCard _crediCard) {
		lastName = _lastName;
		firstName = _firstName;
		address = _address;
		city = _city;
		province = _province;
		country = _country;
		postalCode = _postalCode;
		telephone = _telephone;
		creditCard = _crediCard;
	}

	public int getId() {
		return id;
	}
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
}
