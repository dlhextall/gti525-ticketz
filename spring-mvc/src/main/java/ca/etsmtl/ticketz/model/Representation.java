package ca.etsmtl.ticketz.model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Representation {
	private int id;
	private double prix;
	private DateTime date;
	private List<Billet> billets;
	
	
	public Representation() {
		billets = new ArrayList<Billet>();
	}
	public Representation(int _id, double _prix, DateTime _date, List<Billet> _billets) {
		id = _id;
		prix = _prix;
		date = _date;
		billets = _billets;
	}
	
	
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
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime _date) {
		date = _date;
	}
	public List<Billet> getBillets() {
		return billets;
	}
	public void setBillets(List<Billet> billets) {
		this.billets = billets;
	}
}
