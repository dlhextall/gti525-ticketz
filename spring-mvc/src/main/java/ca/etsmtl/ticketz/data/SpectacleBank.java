package ca.etsmtl.ticketz.data;

import java.util.ArrayList;

import ca.etsmtl.ticketz.model.Spectacle;

public class SpectacleBank{

	public int id;
	public String title; 
	public String description;
	public String salle;
	public String urlImage;
	public RepresentationBank representations;
	public ArrayList<SpectacleBank>lstSpectacle;
	

	private SpectacleBank(int id,String title,String description,String salle,RepresentationBank representations){
		this.id = id;
		this.title = title;
		this.description = description;
		this.salle = salle;
		this.representations = representations;
		
	}
	
	public SpectacleBank(){
		lstSpectacle = Initialize();
	}

	public ArrayList<SpectacleBank> getLstSpectacle() {
		return lstSpectacle;
	}

	public void setLstSpectacle(ArrayList<SpectacleBank> lstSpectacle) {
		this.lstSpectacle = lstSpectacle;
	}


	public ArrayList<SpectacleBank> Initialize(){
		lstSpectacle = new ArrayList<SpectacleBank>();
		RepresentationBank representations = new RepresentationBank();
		lstSpectacle.add(new SpectacleBank(1,"Black Keys Tour","Tickets On Sale Now!","Centre Bell",representations));
		lstSpectacle.add(new SpectacleBank(2,"Snoop Dog Tour","Tickets On Sale Now!","Pepsi Center",representations));
		return lstSpectacle;
	}
	
	
	
	
}
