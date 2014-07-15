package ca.etsmtl.ticketz.model;

import java.math.BigDecimal;

public class LignePanier {
	
	private int idRepresentation;
	private int idSpectacle;
	private int nbBillets;
	private BigDecimal montantTotal;
	private BigDecimal montantUnitaire;	
	private String nomSpectacle;
	
	public LignePanier() { }
	
	public BigDecimal getMontantUnitaire() {
		return montantUnitaire;
	}
	public void setMontantUnitaire(BigDecimal montantUnitaire) {
		this.montantUnitaire = montantUnitaire;
	}	
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
	public BigDecimal getMontantTotal() {
		return getMontantUnitaire().multiply(BigDecimal.valueOf(getNbBillets()));
	}
	
	
}
