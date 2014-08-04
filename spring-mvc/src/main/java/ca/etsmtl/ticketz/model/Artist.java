package ca.etsmtl.ticketz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Artist")
public class Artist implements Serializable {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="biography")
	private String biography;
	
	
	public Artist() {
		this("", "");
	}
	public Artist(String _name) {
		this(_name, "");
	}
	public Artist(String _name, String _biography) {
		name = _name;
		biography = _biography;
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String _biography) {
		biography = _biography;
	}
	
	
	public String toString() {
		return id + " - " + name + " : " + biography;
	}
	
	public boolean equals(Object _obj) {
		if (_obj == this) {
			return true;
		}
		if (!(_obj instanceof Artist)) {
			return false;
		}
		Artist other = (Artist) _obj;
		return id == other.getId() && name == other.getName() && biography == other.getBiography();
	}
}
