package ca.etsmtl.ticketz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CreditCard")
public class CreditCard {

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="last4")
	private String last4;
	@Column(name="lastName")
	private String lastName;
	@Column(name="firstName")
	private String firstName;
	
	
	public CreditCard(String _last4, String _lastName, String _firstName) {
		last4 = _last4;
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
		this.last4 = last4;
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
