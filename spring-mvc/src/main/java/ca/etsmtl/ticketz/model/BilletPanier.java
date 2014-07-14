package ca.etsmtl.ticketz.model;

public class BilletPanier {
	
	private int idRepresentation;
	private int idSpectacle;
	private int nbBillets;
	private Double montantTotal;
	private String nomSpectacle;
	
	public BilletPanier() {}
	
	public int getIdSpectacle() {
		return idSpectacle;
	}
	public void setIdSpectacle(int idSpectacle) {
		this.idSpectacle = idSpectacle;
	}	
	public String getNomSpectacle() {
		return nomSpectacle;
	}
	public void setNomSpectacle(String nomSpectacle) {
		this.nomSpectacle = nomSpectacle;
	}		
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
	public Double getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
	}
	
	
	

}
