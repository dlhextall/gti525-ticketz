package ca.etsmtl.ticketz.dao;

import java.util.ArrayList;

import ca.etsmtl.ticketz.data.ShowBank;
import ca.etsmtl.ticketz.model.Show;

public class ShowDaoStub implements ShowDao {

	ShowBank shows;
	
	public ShowDaoStub(){
		shows = ShowBank.getInstance();
	}
	
	@Override
	public ArrayList<Show> getAllShows() {
		return new ArrayList<Show>(shows.getShows());
	}
	
	@Override
	public Show getShowAt(int id) {
		return shows.getShowsAt(id);
	}

	@Override
	public ArrayList<Show> getFeaturedShows() {
		ArrayList<Show> featuredShows = new ArrayList<Show>();
		for (Show show : shows.getShows()) {
			if (show.isFeatured()) {
				featuredShows.add(show);
			}
		}
		return featuredShows;
	}
}
