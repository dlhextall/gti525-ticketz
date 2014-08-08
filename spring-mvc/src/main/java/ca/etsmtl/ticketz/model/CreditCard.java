package ca.etsmtl.ticketz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CreditCard")
public class CreditCard {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="last4")
	private String last4;
	@Column(name="lastName")
	private String lastName;
	@Column(name="firstName")
	private String firstName;
	
	
	public CreditCard() { }
	public CreditCard(String _ccNumber, String _lastName, String _firstName) {
		last4 = _ccNumber.substring(_ccNumber.length() - 4);
		lastName = _lastName;
		firstName = _firstName;
	}


	public int getId() {
		return id;
	}
	public String getLast4() {
		return last4;
	}
	public void setLast4(String last4) {
		this.last4 = last4.substring(last4.length() - 4);
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
	
}
