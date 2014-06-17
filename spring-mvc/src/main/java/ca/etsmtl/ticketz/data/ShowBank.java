package ca.etsmtl.ticketz.data;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import ca.etsmtl.ticketz.model.Representation;
import ca.etsmtl.ticketz.model.Show;

public class ShowBank {

	private static ShowBank instance = null;
	private List<Show> shows;

	
	protected ShowBank() {
		ArrayList<Representation> representations = new ArrayList<Representation>(RepresentationBank.getInstance().getRepresentations());
		shows = new ArrayList<Show>();
		shows.add(new Show(1, "Black Keys Tour", "Tickets On Sale Now!", "Centre Bell", "/ressources/images/carousel/img1.jpg", representations, null, DateTime.now().minusDays(2), DateTime.now()));
		shows.add(new Show(2, "Snoop Dog Tour", "Tickets On Sale Now!", "Pepsi Center", "/ressources/images/carousel/img2.jpg", representations, null, DateTime.now().minusDays(2), DateTime.now()));
	}


	public static ShowBank getInstance(){
		if (instance == null) {
			instance = new ShowBank();
		}
		return instance;
	}
	
	public List<Show> getShows() {
		return shows;
	}
}
