package ca.etsmtl.ticketz.model;

public class Billet {
	private int id;
	public enum Etat {EnVente,Reserve};
	private Etat etat;
	
	
	public Billet() {}
	public Billet(int _id) {
		this(_id,Etat.EnVente);
	}
	public Billet(int _id, Etat etat) {
		id = _id;
		this.etat = etat;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int _id) {
		id = _id;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
}
