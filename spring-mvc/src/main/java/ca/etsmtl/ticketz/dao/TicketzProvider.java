package ca.etsmtl.ticketz.dao;

import java.util.ArrayList;

import ca.etsmtl.ticketz.model.Show;

public class TicketzProvider {
	
	public static ShowDaoStub stubs;
	
	public static ArrayList<Show> getData(){
		stubs = new ShowDaoStub();
		return stubs.getData();
	}
	
	public static Show getDataAt(int id){
		stubs = new ShowDaoStub();
		return stubs.getDataAt(id);
	}
}
