package ca.etsmtl.ticketz.data;

import java.util.ArrayList;
import java.util.Calendar;


public class RepresentationBank {
	public int id;
	public double prix;
	public Calendar calendar;
	public BilletBank billets;
	public ArrayList<RepresentationBank>lstRepresentation;
	

	private RepresentationBank(int id, double prix, Calendar calendar, BilletBank billets){
		this.id =id;
		this.prix = prix;
		this.calendar = calendar;
		this.billets = billets;
		
	}
	
	public RepresentationBank(){
		lstRepresentation = Initialize();
	}
	
	
	public ArrayList<RepresentationBank> getLstRepresentation() {
		return lstRepresentation;
	}

	public void setLstRepresentation(ArrayList<RepresentationBank> lstRepresentation) {
		this.lstRepresentation = lstRepresentation;
	}
	
	public ArrayList<RepresentationBank> Initialize(){
		ArrayList<RepresentationBank>lstRepresentation = new ArrayList<RepresentationBank>();
		BilletBank billets = new BilletBank();
		lstRepresentation.add(new RepresentationBank(1,50.00,Calendar.getInstance(),billets));
		lstRepresentation.add(new RepresentationBank(2,150.00,Calendar.getInstance(),billets));
		lstRepresentation.add(new RepresentationBank(3,150.00,Calendar.getInstance(),billets));
		lstRepresentation.add(new RepresentationBank(4,150.00,Calendar.getInstance(),billets));
		
		return lstRepresentation;
	}
}
