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
	private int cptAdded=0;
	private int cptReserve=0;
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
		
		
		List<Billet>lstBillet = spectacle.get(billetPanier.getIdSpectacle()).representations.get(billetPanier.getIdRepresentation()).getBillets();
		

		cptAdded=0;
		while(cpt<lstBillet.size()&&cptAdded<billetPanier.getNbBillets()){
			
			if(lstBillet.get(cpt).getEtat().equals(Etat.EnVente)){
				
				lstBillet.get(cpt).setEtat(Etat.Reserve);
				cptAdded++;
			}
			
			/*if(lstBillet.get(cpt).getEtat().equals(Etat.Reserve)){
				cptReserve++;
			}*/
			cpt++;
			
			if(cptAdded==billetPanier.getNbBillets()){
				panier.getLstBilletPanier().add(billetPanier); 
			}
			/*else if(cptReserve>=lstBillet.size()){
				System.out.println("full");
				break;
			}*/
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
