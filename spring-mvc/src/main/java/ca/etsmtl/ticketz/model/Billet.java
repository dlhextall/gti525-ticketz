package ca.etsmtl.ticketz.model;

import java.util.ArrayList;

public class Billet {
	public int id;
	public enum Etat {EnVente,Reserve};
	public Etat etat;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
}
