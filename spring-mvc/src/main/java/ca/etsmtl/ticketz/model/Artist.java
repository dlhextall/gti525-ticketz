package ca.etsmtl.ticketz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Artist implements Serializable {

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="biography")
	private String biography;
	
	
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
}
