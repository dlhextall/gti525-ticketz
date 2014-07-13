package ca.etsmtl.ticketz.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

public class Panier{
	private List<BilletPanier> lstBillet;
	private double sousTotal,tvq,tps,prixTotal;
	
	public Panier(){
		lstBillet = new ArrayList<BilletPanier>();
		sousTotal=0;
		tvq=0;
		tps=0;
		prixTotal=0;
	}
	
	

	public List<BilletPanier> getLstBillet() {
		return lstBillet;
	}



	public void setLstBillet(List<BilletPanier> lstBillet) {
		this.lstBillet = lstBillet;
	}



	public double getSousTotal() {
		
		return sousTotal;
	}

	public void setSousTotal(double sousTotal) {
		this.sousTotal = sousTotal;
	}

	public double getTvq() {
		return tvq;
	}

	public void setTvq(double tvq) {
		this.tvq = tvq;
	}

	public double getTps() {
		return tps;
	}

	public void setTps(double tps) {
		this.tps = tps;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

}
