package ca.etsmtl.ticketz.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import ca.etsmtl.ticketz.model.Show;

@Scope(value="singleton")
public class TicketzProvider {
	
	@Autowired
	private IShowDao showDao;
	
	
	public TicketzProvider() { }
	
	
	public List<Show> getAllShows(){
		return showDao.getAllShows();
	}
	
	public Show getShowAt(int id){
		return showDao.getShowAt(id);
	}
	
	public List<Show> getFeaturedShows() {
		return showDao.getFeaturedShows();
	}
	
	public List<Show> getMatchingShows(String _criteria) {
		return showDao.getShowsMatching(_criteria);
	}
}
