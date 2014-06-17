package ca.etsmtl.ticketz.model;

public class Billet {
	private int id;
	private boolean reserve; 
	
	
	public Billet() {}
	public Billet(int _id) {
		this(_id, false);
	}
	public Billet(int _id, boolean _reserve) {
		id = _id;
		reserve = _reserve;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int _id) {
		id = _id;
	}
	public boolean isReserve() {
		return reserve;
	}
	public void setReserve(boolean _reserve) {
		reserve = _reserve;
	}
}
