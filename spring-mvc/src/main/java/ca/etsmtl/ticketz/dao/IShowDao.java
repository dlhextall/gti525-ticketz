package ca.etsmtl.ticketz.dao;

import java.util.List;

import ca.etsmtl.ticketz.exception.ShowNotFoundException;
import ca.etsmtl.ticketz.model.Show;

public interface IShowDao {
	public List<Show> getAllShows();
	public Show getShowAt(int id) throws ShowNotFoundException;
	public List<Show> getFeaturedShows();
	public List<Show> getShowsMatching(String _criteria);
}
