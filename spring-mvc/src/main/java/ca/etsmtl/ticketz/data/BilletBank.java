package ca.etsmtl.ticketz.data;

import java.util.ArrayList;
import java.util.List;

import ca.etsmtl.ticketz.model.Billet;

public class BilletBank {
	
	private static BilletBank instance = null;
	private List<Billet> billets;
	
	
	protected BilletBank() {
		billets = new ArrayList<Billet>();
		billets.add(new Billet(1));
		billets.add(new Billet(2));
		billets.add(new Billet(3));
		billets.add(new Billet(4));
		billets.add(new Billet(5));
		billets.add(new Billet(6));
		billets.add(new Billet(7));
		billets.add(new Billet(8));
		billets.add(new Billet(9));
		billets.add(new Billet(10));
	}
	
	
	public static BilletBank getInstance() {
		if (instance == null) {
			instance = new BilletBank();
		}
		return instance;
	}
	
	public List<Billet> getBillets() {
		return billets;
	}
}
