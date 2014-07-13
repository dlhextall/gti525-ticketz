package ca.etsmtl.ticketz.model;

public class BilletPanier {
	
	private int idRepresentation;
	private int nbBillets;
	private int montantTotal;
	
	public BilletPanier() {}
	
	public int getIdRepresentation() {
		return idRepresentation;
	}
	public void setIdRepresentation(int idRepresentation) {
		this.idRepresentation = idRepresentation;
	}
	public int getNbBillets() {
		return nbBillets;
	}
	public void setNbBillets(int nbBillets) {
		this.nbBillets = nbBillets;
	}
	public int getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(int montantTotal) {
		this.montantTotal = montantTotal;
	}
	
	
	

}
