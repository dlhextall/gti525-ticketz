package ca.etsmtl.ticketz.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

public class Panier{
	private List<Show> lstSpectacle;
	private double sousTotal,tvq,tps,prixTotal;
	
	public Panier(){
		lstSpectacle = new ArrayList<Show>();
		sousTotal=0;
		tvq=0;
		tps=0;
		prixTotal=0;
	}
	
	public List<Show> getLstSpectacle() {
		return lstSpectacle;
	}

	public void setLstSpectacle(List<Show> lstSpectacle) {
		this.lstSpectacle = lstSpectacle;
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
