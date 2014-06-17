package ca.etsmtl.ticketz.dao;

import java.util.ArrayList;

import ca.etsmtl.ticketz.model.Show;

public class TicketzProvider {
	
	public static ShowDaoStub stubs;
	
	public static ArrayList<Show> getAllShows(){
		stubs = new ShowDaoStub();
		return stubs.getAllShows();
	}
	
	public static Show getShowAt(int id){
		stubs = new ShowDaoStub();
		return stubs.getShowAt(id);
	}
}
