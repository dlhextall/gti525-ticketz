package ca.etsmtl.ticketz.model;

import java.util.ArrayList;

public class Spectacle {
	public int id;
	public String title; 
	public String description;
	public String salle;
	public String urlImage;
	public ArrayList<Representation> lstRepresentation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public ArrayList<Representation> getLstRepresentation() {
		return lstRepresentation;
	}
	public void setLstRepresentation(ArrayList<Representation> lstRepresentation) {
		this.lstRepresentation = lstRepresentation;
	}
	
}
