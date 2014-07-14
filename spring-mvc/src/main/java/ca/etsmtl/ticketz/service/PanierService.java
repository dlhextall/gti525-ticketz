package ca.etsmtl.ticketz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.etsmtl.ticketz.data.BilletBank;
import ca.etsmtl.ticketz.data.ShowBank;
import ca.etsmtl.ticketz.model.Billet;
import ca.etsmtl.ticketz.model.Billet.Etat;
import ca.etsmtl.ticketz.model.BilletPanier;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.model.Show;
@Service("service")
public class PanierService implements IService{
	private Panier panier;
	private List<Show> spectacle;
	private List <Panier>lstPanier;
	
	public PanierService(){
		panier = new Panier();
		spectacle = ShowBank.getInstance().getShows();
	}
	
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	public List<BilletPanier> getAllBilletPanier(){
		return panier.getLstBilletPanier();
	}
	
	@Override
	public void add(BilletPanier billetPanier) {
		int cpt =0;
		int cptReserve=0;
		panier.getLstBilletPanier().add(billetPanier); 
		List<Billet>lstBillet = spectacle.get(billetPanier.getIdSpectacle()).representations.get(billetPanier.getIdRepresentation()).getBillets();
		
		while(lstBillet.size()!=0 && billetPanier.getNbBillets()!=cptReserve){
			
			if(lstBillet.get(cpt).getEtat().equals(Etat.EnVente)){
				
				lstBillet.get(cpt).setEtat(Etat.Reserve);
				cptReserve++;
			}
			cpt++;
		}
		
	
	}
	@Override
	public void delete(int idSpectacle,int idRepresentation, int indexPanier){
		int cpt =0;
		panier.getLstBilletPanier().remove(indexPanier);
		
		List<Billet>lstBillet = spectacle.get(idSpectacle).representations.get(idRepresentation).getBillets();
		while(lstBillet.size()!=0 ){
			if(lstBillet.get(cpt).getEtat().equals(Etat.Reserve)){
				lstBillet.get(cpt).setEtat(Etat.EnVente);
				break;
			}
			cpt++;
		}
		
		
	}
	
}
