package ca.etsmtl.ticketz.data;

import java.util.ArrayList;

public class ShowBank{

	public int id;
	public String title; 
	public String description;
	public String salle;
	public String urlImage;
	public ArrayList<RepresentationBank> representations;
	//public ArrayList<SpectacleBank>lstSpectacle;

	
	public ShowBank() {}

	private ShowBank(int id,String title,String description,String salle,ArrayList<RepresentationBank> representations){
		this.id = id;
		this.title = title;
		this.description = description;
		this.salle = salle;
		this.representations = representations;
		
	}


	public ArrayList<ShowBank> initialize(){
		ArrayList<ShowBank>lstSpectacle = new ArrayList<ShowBank>();
		RepresentationBank representation = new RepresentationBank();
		ArrayList<RepresentationBank> representations = representation.initialize();
		lstSpectacle.add(new ShowBank(1,"Black Keys Tour","Tickets On Sale Now!","Centre Bell",representations));
		lstSpectacle.add(new ShowBank(2,"Snoop Dog Tour","Tickets On Sale Now!","Pepsi Center",representations));
		return lstSpectacle;
	}
}
