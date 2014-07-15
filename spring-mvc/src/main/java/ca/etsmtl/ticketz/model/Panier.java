package ca.etsmtl.ticketz.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

public class Panier{
	private List<LignePanier> lstLignePanier;
	private static double TAUX_TPS = 0.05;
	private static double TAUX_TVQ = 0.09975;
	
	
	public Panier() {
		lstLignePanier = new ArrayList<LignePanier>();
	}
	
	
	public List<LignePanier> getLstBilletPanier() {
		return lstLignePanier;
	}
	public void setLstBilletPanier(List<LignePanier> lstLignePanier) {
		this.lstLignePanier = lstLignePanier;
	}

	public BigDecimal getSousTotal() {
		BigDecimal sousTotal = new BigDecimal(0);		
		for (LignePanier lignePanier : lstLignePanier) {			
			sousTotal = sousTotal.add(lignePanier.getMontantTotal());			
		}		
		return sousTotal;
	}
	public BigDecimal getTps() {
		return getSousTotal().multiply(BigDecimal.valueOf(TAUX_TPS));
	}
	public BigDecimal getTvq() {
		return getSousTotal().add(getTps()).multiply(BigDecimal.valueOf(TAUX_TVQ));
	}
	public BigDecimal getPrixTotal() {
		return getSousTotal().add(getTps()).add(getTvq()).setScale(2, BigDecimal.ROUND_DOWN);
	}

}
