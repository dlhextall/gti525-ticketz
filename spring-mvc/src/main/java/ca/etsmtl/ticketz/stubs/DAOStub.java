package ca.etsmtl.ticketz.stubs;

import java.util.ArrayList;
import java.util.Iterator;

import ca.etsmtl.ticketz.data.BilletBank;
import ca.etsmtl.ticketz.data.BilletBank.Etat;
import ca.etsmtl.ticketz.data.RepresentationBank;
import ca.etsmtl.ticketz.data.SpectacleBank;
import ca.etsmtl.ticketz.model.Billet;
//import ca.etsmtl.ticketz.model.Billet.Etat;
import ca.etsmtl.ticketz.model.Representation;
import ca.etsmtl.ticketz.model.Spectacle;

public class DAOStub implements IStubs {

	SpectacleBank spectacles;
	
	public DAOStub(){
		spectacles = new SpectacleBank();
	}
	
	@Override
	public ArrayList<Spectacle> GetData() {
		ArrayList<Spectacle> lstSpectacles = new ArrayList<Spectacle>();
		ArrayList<Representation> lstRepresentation = new ArrayList<Representation>();
		ArrayList<Billet> lstBillets = new ArrayList<Billet>();
		
		for(SpectacleBank spectacleBank:spectacles.getLstSpectacle()){
			Spectacle spectacle = new Spectacle();
			spectacle.setId(spectacleBank.id);
			spectacle.setDescription(spectacleBank.description);
			spectacle.setTitle(spectacleBank.title);
			spectacle.setSalle(spectacleBank.salle);
			spectacle.setUrlImage(spectacleBank.urlImage);
			
			for(RepresentationBank representationBank:spectacleBank.representations.getLstRepresentation()){
				Representation representation = new Representation();
				representation.setId(representationBank.id);
				representation.setPrix(representationBank.prix);
				representation.setCalendar(representationBank.calendar);
				
				for(BilletBank billetBank:spectacleBank.representations.billets.getLstBillets()){
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
			spectacle.setLstRepresentation(lstRepresentation);
			lstSpectacles.add(spectacle);
		}
		
		return lstSpectacles;
	}




	

}
