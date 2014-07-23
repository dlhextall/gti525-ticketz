package ca.etsmtl.ticketz.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import ca.etsmtl.ticketz.model.Ticket;
import ca.etsmtl.ticketz.model.Representation;


public class RepresentationBank {
	
	private static RepresentationBank instance = null;
	private List<Representation> representations;
	
	
	protected RepresentationBank() {
		ArrayList<Ticket> billets = new ArrayList<Ticket>(BilletBank.getInstance().getBillets());
		representations = new ArrayList<Representation>();
		representations.add(new Representation(1, new BigDecimal(50.00), DateTime.now(), billets));		
	}
	
	
	public static RepresentationBank getInstance() {
		if (instance == null) {
			instance = new RepresentationBank();
		}
		return instance;
	}
	
	public List<Representation> getRepresentations() {
		return representations;
	}
}
