package ca.etsmtl.ticketz.data;

import java.util.ArrayList;

public class BilletBank {
	public int id;
	public enum Etat {EnVente,Reserve};
	public Etat etat;
	public ArrayList<BilletBank> lstBillets;
	
	private BilletBank(int id, Etat etat){
		this.id = id;
		this.etat = etat;
	}
	public BilletBank(){
		
	}
	
	
	
	public ArrayList<BilletBank> Initialize(){
		ArrayList<BilletBank>lstBillets = new ArrayList<BilletBank>();
		lstBillets.add(new BilletBank(1,Etat.EnVente));
		lstBillets.add(new BilletBank(2,Etat.EnVente));
		lstBillets.add(new BilletBank(3,Etat.EnVente));
		lstBillets.add(new BilletBank(4,Etat.EnVente));
		lstBillets.add(new BilletBank(5,Etat.EnVente));
		lstBillets.add(new BilletBank(6,Etat.EnVente));
		lstBillets.add(new BilletBank(7,Etat.EnVente));
		lstBillets.add(new BilletBank(8,Etat.EnVente));
		lstBillets.add(new BilletBank(9,Etat.EnVente));
		lstBillets.add(new BilletBank(10,Etat.EnVente));
		return lstBillets;
	}
}
