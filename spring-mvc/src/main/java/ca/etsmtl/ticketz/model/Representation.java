package ca.etsmtl.ticketz.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="Representation")
public class Representation {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="price")
	private BigDecimal price;
	@Column(name="moment")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime date;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Representation_Ticket",
				joinColumns={@JoinColumn(name="r_id")},
				inverseJoinColumns={@JoinColumn(name="t_id")})
	private List<Ticket> billets;
	
	
	public Representation() {
		billets = new ArrayList<Ticket>();
	}
	public Representation(int _id, BigDecimal _prix, DateTime _date, List<Ticket> _billets) {
		id = _id;
		price = _prix;
		date = _date;
		billets = _billets;
	}
	
	
	public int getId() {
		return id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal _price) {
		this.price = _price;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime _date) {
		date = _date;
	}
	public List<Ticket> getBillets() {
		return billets;
	}
	public void setBillets(List<Ticket> billets) {
		this.billets = billets;
	}
}
