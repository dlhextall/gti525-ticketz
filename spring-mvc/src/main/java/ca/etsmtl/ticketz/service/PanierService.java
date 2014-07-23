package ca.etsmtl.ticketz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.etsmtl.ticketz.data.BilletBank;
import ca.etsmtl.ticketz.data.ShowBank;
import ca.etsmtl.ticketz.model.Billet;
import ca.etsmtl.ticketz.model.Billet.Etat;
import ca.etsmtl.ticketz.model.LignePanier;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.model.Representation;
import ca.etsmtl.ticketz.model.Show;
@Service("service")
public class PanierService implements IService{
	private static PanierService instance = null;
	private Panier panier =new Panier();
	private List<Show> lstShows;
	private int cptAdded = 0;
	private int cptRemoved = 0;
	private int cptReserve = 0;
	private int represBilletReserve = 0;
	private int nbItemsPanier;
	private final int LIMITE_TICKET = 6;
	
	protected PanierService(){
		//panier = new Panier();
		lstShows = ShowBank.getInstance().getShows();
	}
	
	public static PanierService getInstance(){
		if (instance == null) {
			instance = new PanierService();
		}
		return instance;
	}
	
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	public int getCptAdded() {
		return cptAdded;
	}

	public void setCptAdded(int cptAdded) {
		this.cptAdded = cptAdded;
	}

	public int getCptRemoved() {
		return cptRemoved;
	}

	public void setCptRemoved(int cptRemoved) {
		this.cptRemoved = cptRemoved;
	}

	public int getNbItemsPanier() {
		return nbItemsPanier;
	}

	public void setNbItemsPanier(int nbItemsPanier) {
		this.nbItemsPanier = nbItemsPanier;
	}

	public List<LignePanier> getAllBilletPanier(){
		return panier.getLstBilletPanier();
	}
	
	public int getCptReserve() {
		return cptReserve;
	}

	public void setCptReserve(int cptReserve) {
		this.cptReserve = cptReserve;
	}
	
	@Override
	public void add(LignePanier billetPanier) {
		List<Billet>lstBillet = lstShows.get(billetPanier.getIdSpectacle()).getRepresentations().get(billetPanier.getIdRepresentation()).getBillets();
		//lstShows.get(billetPanier.getIdSpectacle()).getRepresentations().get(billetPanier.getIdRepresentation()).setBilletReserve(cptReserve);
		
		//represBilletReserve = lstShows.get(billetPanier.getIdSpectacle()).getRepresentations().get(billetPanier.getIdRepresentation()).getBilletReserve();
		cptAdded=0;
		
		
		for (int i = 0; i < lstBillet.size(); i++) {
			int panierCheck=nbItemsPanier+billetPanier.getNbBillets();
			
			if(lstBillet.get(i).getEtat().equals(Etat.Reserve)){
				cptReserve++;
			}
			
			if (lstBillet.get(i).getEtat().equals(Etat.EnVente)) {
				
				if(cptReserve > billetPanier.getNbBillets()){
					if(nbItemsPanier<=cptReserve&&panierCheck<=LIMITE_TICKET){
						lstBillet.get(i).setEtat(Etat.Reserve);
						//cptAdded++;
						cptReserve++;
						
						panier.getLstBilletPanier().add(billetPanier); 
						nbItemsPanier+=billetPanier.getNbBillets();
						//lstShows.get(billetPanier.getIdSpectacle()).getRepresentations().get(billetPanier.getIdRepresentation()).setBilletReserve(cptReserve++);
					}
					else{
						break;
					}
				}
				else{
					if(nbItemsPanier<=cptReserve){
						lstBillet.get(i).setEtat(Etat.Reserve);
						cptAdded++;
						cptReserve++;
						//lstShows.get(billetPanier.getIdSpectacle()).getRepresentations().get(billetPanier.getIdRepresentation()).setBilletReserve(cptReserve++);
					}
				}

			}
			
			if(cptAdded==billetPanier.getNbBillets()&&nbItemsPanier<=LIMITE_TICKET){
				panier.getLstBilletPanier().add(billetPanier); 
				nbItemsPanier+=billetPanier.getNbBillets();
				break;
			}
			if(cptAdded==billetPanier.getNbBillets()){
				
			}
		}
		
	
	}
	

	@Override
	public void delete(int idSpectacle,int idRepresentation, int indexPanier){
		int cpt =0;
		cptRemoved=0;
		List<Billet>lstBillet = lstShows.get(idSpectacle).getRepresentations().get(idRepresentation).getBillets();
		
		
		
		for(int i=0;i<lstBillet.size();i++){
			if(lstBillet.get(i).getEtat().equals(Etat.Reserve)){
				lstBillet.get(i).setEtat(Etat.EnVente);
				//cptReserve--;
				//lstShows.get(idSpectacle).getRepresentations().get(idRepresentation).setBilletReserve(cptReserve--);
				cptRemoved++;
				
				if(cptRemoved==panier.getLstBilletPanier().get(indexPanier).getNbBillets()){
					nbItemsPanier-=panier.getLstBilletPanier().get(indexPanier).getNbBillets();
					panier.getLstBilletPanier().remove(indexPanier);
					break;
				}
			
			}
			
		}
		
	}
	
	@Override
	public void deleteFinal(int idSpectacle,int idRepresentation, int indexPanier){
		List<Billet>lstBillet = lstShows.get(idSpectacle).getRepresentations().get(idRepresentation).getBillets();
		for(int i=0;i<lstBillet.size();i++){
			if(lstBillet.get(i).getEtat().equals(Etat.Reserve)){
				lstBillet.remove(i);
				
			}
		}
	}
	
	public void deleteAll() {
		for (Show show : lstShows) {
			for (Representation representation : lstShows.get(show.getId()).getRepresentations()) {
				for (Billet billet : representation.getBillets()) {
					if (billet.getEtat().equals(Etat.Reserve)) {
						representation.getBillets().remove(billet);
					}
				}
			}
		}
	}

	@Override
	public void deleteCart() {
		if(panier!=null){
			panier=null;
		}
		
		
	}
	
}
