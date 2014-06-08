package ca.etsmtl.ticketz.model;

import java.io.Serializable;

public class Artist implements Serializable {

	private int id;
	private String name;
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
	public void setId(int _id) {
		id = _id;
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
