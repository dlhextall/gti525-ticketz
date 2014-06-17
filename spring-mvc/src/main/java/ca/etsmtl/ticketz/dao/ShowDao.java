package ca.etsmtl.ticketz.dao;

import java.util.ArrayList;

public interface ShowDao<Show> {
	public ArrayList<Show> getAllShows();
	public Show getShowAt(int id);
}
