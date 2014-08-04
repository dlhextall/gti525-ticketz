package ca.etsmtl.ticketz.service;

import java.util.List;

import ca.etsmtl.ticketz.exception.ShowNotFoundException;
import ca.etsmtl.ticketz.model.Show;

public interface IShowService {
	
	public List<Show> getAllShows();
	
	public Show getShowAt(int id) throws ShowNotFoundException;
	
	public List<Show> getFeaturedShows();
	
	public List<Show> getMatchingShows(String _criteria);
	
}
