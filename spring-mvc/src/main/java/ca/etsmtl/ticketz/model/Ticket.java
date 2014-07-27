package ca.etsmtl.ticketz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ticket")
public class Ticket {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;


	public enum State { AVAILABLE, RESERVED,SOLD };

	@Column(name="state")
	@Enumerated(EnumType.STRING)
	private State state;
	
	
	public Ticket() {
		state = State.AVAILABLE;
	}
	public Ticket(int _id) {
		this(_id, State.AVAILABLE);
	}
	public Ticket(int _id, State _state) {
		id = _id;
		this.state = _state;
	}
	
	
	public int getId() {
		return id;
	}
	public State getState() {
		return state;
	}
	public void setState(State _state) {
		this.state = _state;
	}
	
}
