package ca.etsmtl.ticketz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.etsmtl.ticketz.data.BilletBank;
import ca.etsmtl.ticketz.data.ShowBank;
import ca.etsmtl.ticketz.model.Billet;
import ca.etsmtl.ticketz.model.Billet.Etat;
import ca.etsmtl.ticketz.model.LignePanier;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.model.Show;
@Service("service")
public class PanierService implements IService{
	private Panier panier;
	private List<Show> spectacle;
	private List <Panier>lstPanier;
	private int cptAdded=0;
	private int cptRemoved=0;
	private int cptReserve=0;
	private int represBilletReserve =0;
	private int nbItemsPanier;
	final int LIMITE_TICKET = 6;
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
	
	public List<LignePanier> getAllBilletPanier(){
		return panier.getLstBilletPanier();
	}
	
	@Override
	public void add(LignePanier billetPanier) {
		List<Billet>lstBillet = spectacle.get(billetPanier.getIdSpectacle()).representations.get(billetPanier.getIdRepresentation()).getBillets();
		spectacle.get(billetPanier.getIdSpectacle()).representations.get(billetPanier.getIdRepresentation()).setBilletReserve(cptReserve);
		represBilletReserve = spectacle.get(billetPanier.getIdSpectacle()).representations.get(billetPanier.getIdRepresentation()).getBilletReserve();
		cptAdded=0;
		
			for(int i=0;i<lstBillet.size();i++){
				int panierCheck=nbItemsPanier+billetPanier.getNbBillets();
				if(lstBillet.get(i).getEtat().equals(Etat.EnVente)){
					
					if(represBilletReserve>billetPanier.getNbBillets()){
						if(nbItemsPanier<=represBilletReserve&&panierCheck<=LIMITE_TICKET){
							lstBillet.get(i).setEtat(Etat.Reserve);
							cptAdded++;
							spectacle.get(billetPanier.getIdSpectacle()).representations.get(billetPanier.getIdRepresentation()).setBilletReserve(cptReserve++);
						}
						else{
							break;
						}
					}
					else{
						if(nbItemsPanier<=represBilletReserve){
							lstBillet.get(i).setEtat(Etat.Reserve);
							cptAdded++;
							spectacle.get(billetPanier.getIdSpectacle()).representations.get(billetPanier.getIdRepresentation()).setBilletReserve(cptReserve++);
						}
					}
	
				}

				if(cptAdded==billetPanier.getNbBillets()&&nbItemsPanier<=represBilletReserve){
					panier.getLstBilletPanier().add(billetPanier); 
					nbItemsPanier+=billetPanier.getNbBillets();
				}
				if(cptAdded==billetPanier.getNbBillets()){
					break;
				}
			}
		
	
	}
	@Override
	public void delete(int idSpectacle,int idRepresentation, int indexPanier){
		int cpt =0;
		//cptReserve= cptReserve-panier.getLstBilletPanier().get(indexPanier).getNbBillets();
		cptRemoved=0;
		List<Billet>lstBillet = spectacle.get(idSpectacle).representations.get(idRepresentation).getBillets();
		for(int i=0;i<lstBillet.size();i++){
			if(lstBillet.get(i).getEtat().equals(Etat.Reserve)){
				lstBillet.get(i).setEtat(Etat.EnVente);
				spectacle.get(idSpectacle).representations.get(idRepresentation).setBilletReserve(cptReserve--);
				cptRemoved++;
				
				if(cptRemoved==panier.getLstBilletPanier().get(indexPanier).getNbBillets()){
					nbItemsPanier-=panier.getLstBilletPanier().get(indexPanier).getNbBillets();
					panier.getLstBilletPanier().remove(indexPanier);
					break;
				}
			
			}
			
		}
		
		
	}
	
}
