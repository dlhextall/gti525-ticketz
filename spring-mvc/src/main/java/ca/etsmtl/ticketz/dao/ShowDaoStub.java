package ca.etsmtl.ticketz.dao;

import java.util.ArrayList;
import java.util.Iterator;

import ca.etsmtl.ticketz.data.BilletBank;
import ca.etsmtl.ticketz.data.BilletBank.Etat;
import ca.etsmtl.ticketz.data.RepresentationBank;
import ca.etsmtl.ticketz.data.ShowBank;
import ca.etsmtl.ticketz.model.Billet;
//import ca.etsmtl.ticketz.model.Billet.Etat;
import ca.etsmtl.ticketz.model.Representation;
import ca.etsmtl.ticketz.model.Show;

public class ShowDaoStub implements ShowDao {

	ShowBank spectacles;
	
	public ShowDaoStub(){
		spectacles = new ShowBank();
	}
	
	@Override
	public ArrayList<Show> getData() {
		ArrayList<Show> lstSpectacles = new ArrayList<Show>();
		ArrayList<Representation> lstRepresentation = new ArrayList<Representation>();
		ArrayList<Billet> lstBillets = new ArrayList<Billet>();
		
		for(ShowBank spectacleBank:spectacles.initialize()){
			Show spectacle = new Show();
			spectacle.setId(spectacleBank.id);
			spectacle.setDescription(spectacleBank.description);
			spectacle.setName(spectacleBank.title);
			spectacle.setSalle(spectacleBank.salle);
			spectacle.setImageUrl(spectacleBank.urlImage);
			
			for(RepresentationBank representationBank:spectacleBank.representations){
				Representation representation = new Representation();
				representation.setId(representationBank.id);
				representation.setPrix(representationBank.prix);
				representation.setCalendar(representationBank.calendar);
				
				for(BilletBank billetBank:representationBank.billets){
					Billet billet = new Billet();
					billet.setId(billetBank.id);
					if(billetBank.etat==Etat.EnVente){
						billet.setEtat(billet.etat.EnVente);
					}
					else{
						billet.setEtat(billet.etat.Reserve);
					}
					lstBillets.add(billet);
				}
				representation.setBillets(lstBillets);
				lstRepresentation.add(representation);
			}
			spectacle.setRepresentations(lstRepresentation);
			lstSpectacles.add(spectacle);
		}
		
		return lstSpectacles;
	}




	

}
