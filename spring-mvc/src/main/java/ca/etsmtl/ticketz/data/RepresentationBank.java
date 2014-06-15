package ca.etsmtl.ticketz.data;

import java.util.ArrayList;
import java.util.Calendar;


public class RepresentationBank {
	public int id;
	public double prix;
	public Calendar calendar;
	public ArrayList<BilletBank> billets;

	
	public RepresentationBank() {}

	private RepresentationBank(int id, double prix, Calendar calendar, ArrayList<BilletBank> billets){
		this.id =id;
		this.prix = prix;
		this.calendar = calendar;
		this.billets = billets;
	}
	
	
	public ArrayList<RepresentationBank> initialize(){
		ArrayList<RepresentationBank>lstRepresentation = new ArrayList<RepresentationBank>();
		BilletBank billet = new BilletBank();
		ArrayList<BilletBank> billets = billet.Initialize();
		lstRepresentation.add(new RepresentationBank(1,50.00,Calendar.getInstance(),billets));
		lstRepresentation.add(new RepresentationBank(2,150.00,Calendar.getInstance(),billets));
		lstRepresentation.add(new RepresentationBank(3,150.00,Calendar.getInstance(),billets));
		lstRepresentation.add(new RepresentationBank(4,150.00,Calendar.getInstance(),billets));
		
		return lstRepresentation;
	}
}
