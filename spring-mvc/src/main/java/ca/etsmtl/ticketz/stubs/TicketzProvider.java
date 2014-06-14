package ca.etsmtl.ticketz.stubs;

import java.util.ArrayList;

import ca.etsmtl.ticketz.model.Spectacle;

public class TicketzProvider {
	
	public static DAOStub stubs;
	
	public static ArrayList<Spectacle> getData(){
		stubs = new DAOStub();
		return stubs.GetData();
	}
}
