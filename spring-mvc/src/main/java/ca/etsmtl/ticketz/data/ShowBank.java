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
		shows.add(new Show(0, "Black Keys Tour", "The Black Keys est un groupe de blues rock américain originaire d'Akron dans l'État de l'Ohio1,2. Le groupe est composé du chanteur et guitariste Dan Auerbach et du batteur Patrick Carney.", "Centre Bell", "resources/images/carousel/img1.jpg", representations, null, DateTime.now().minusDays(2), DateTime.now(), true));
		shows.add(new Show(1, "Snoop Dog Tour", "Tickets On Sale Now!", "Pepsi Center", "resources/images/carousel/img2.jpg", representations, null, DateTime.now().minusDays(2), DateTime.now(), true));
		shows.add(new Show(2, "Imagine Dragon", "Imagine Dragons est un groupe de rock alternatif américain formé en 2008 à Las Vegas, dans le Nevada", "Bell Centre", "resources/images/carousel/img3.jpg", representations, null, DateTime.now().minusDays(2), DateTime.now(), true));

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
	
	public Show getShowsAt(int id) {
		return shows.get(id);
	}
}
