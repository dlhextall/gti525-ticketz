package ca.etsmtl.ticketz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name="ClientOrder")
public class ClientOrder {

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="moment")
	private DateTime date;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ClientOrder_Representation",
				joinColumns={@JoinColumn(name="co_id")},
				inverseJoinColumns={@JoinColumn(name="r_id")})
	private List<Representation> representations;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name="ClientOrder_Client",
				joinColumns={@JoinColumn(name="co_id")},
				inverseJoinColumns={@JoinColumn(name="c_id")})
	private Client client;
	
	
	public ClientOrder(DateTime _date, Client _client) {
		this(_date, new ArrayList<Representation>(), _client);
	}
	public ClientOrder(DateTime _date, List<Representation> _lstRepresentations, Client _client) {
		date = _date;
		representations = _lstRepresentations;
		client = _client;
	}
	

	public int getId() {
		return id;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public List<Representation> getRepresentations() {
		return representations;
	}
	public Representation getRepresentationAt(int _index) {
		return representations.get(_index);
	}
	public void setRepresentations(List<Representation> representations) {
		this.representations = representations;
	}
	public void addRepresentation(Representation _representation) {
		representations.add(_representation);
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
