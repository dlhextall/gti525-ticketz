package ca.etsmtl.ticketz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.etsmtl.ticketz.data.BilletBank;
import ca.etsmtl.ticketz.model.Billet;
import ca.etsmtl.ticketz.model.Billet.Etat;
import ca.etsmtl.ticketz.model.BilletPanier;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.model.Show;
@Service("service")
public class PanierService implements IService{
	private Panier panier;
	private Show spectacle;
	private List <Panier>lstPanier;
	
	public PanierService(){
		panier = new Panier();
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
		List<Billet>lstBillet = spectacle.representations.get(billetPanier.getIdRepresentation()).getBillets();
		
		while(lstBillet.size()!=0 && billetPanier.getNbBillets()!=cptReserve){
			
			if(lstBillet.get(cpt).getEtat().equals(Etat.EnVente)){
				
				lstBillet.get(cpt).setEtat(Etat.Reserve);
				cptReserve++;
			}
			cpt++;
		}
		
	
	}
	
	public void delete(int index){
		
	}
	
}
