package ca.etsmtl.ticketz.data;

import java.util.ArrayList;
import java.util.List;

import ca.etsmtl.ticketz.model.Ticket;

public class BilletBank {
	
	private static BilletBank instance = null;
	private List<Ticket> billets;
	
	
	protected BilletBank() {
		billets = new ArrayList<Ticket>();
		billets.add(new Ticket(1));
		billets.add(new Ticket(2));
		billets.add(new Ticket(3));
		billets.add(new Ticket(4));
		billets.add(new Ticket(5));
		billets.add(new Ticket(6));
		billets.add(new Ticket(7));
		billets.add(new Ticket(8));
		billets.add(new Ticket(9));
		billets.add(new Ticket(10));
	}
	
	
	public static BilletBank getInstance() {
		if (instance == null) {
			instance = new BilletBank();
		}
		return instance;
	}
	
	public List<Ticket> getBillets() {
		return billets;
	}
}
