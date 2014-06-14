package ca.etsmtl.ticketz.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Representation {
	public int id;
	public double prix;
	public Calendar calendar;
	public ArrayList<Billet> billets;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public ArrayList<Billet> getBillets() {
		return billets;
	}
	public void setBillets(ArrayList<Billet> billets) {
		this.billets = billets;
	}
	
	
}
