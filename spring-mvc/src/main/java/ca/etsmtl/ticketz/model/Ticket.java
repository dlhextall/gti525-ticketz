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
	public enum State {EnVente, Reserve, Vendu};
	@Column(name="state")
	@Enumerated(EnumType.STRING)
	private State state;
	
	
	public Ticket() {
		state = State.EnVente;
	}
	public Ticket(int _id) {
		this(_id, State.EnVente);
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
