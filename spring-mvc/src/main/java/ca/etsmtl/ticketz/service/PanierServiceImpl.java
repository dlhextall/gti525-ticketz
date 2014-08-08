package ca.etsmtl.ticketz.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.etsmtl.ticketz.dao.IShowDao;
import ca.etsmtl.ticketz.dao.ShowDaoImpl;
import ca.etsmtl.ticketz.dao.ShowDaoStub;
import ca.etsmtl.ticketz.data.BilletBank;
import ca.etsmtl.ticketz.data.ShowBank;
import ca.etsmtl.ticketz.model.Ticket;
import ca.etsmtl.ticketz.model.LignePanier;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.model.Representation;
import ca.etsmtl.ticketz.model.Show;
import ca.etsmtl.ticketz.model.Ticket.State;


public class PanierServiceImpl implements IPanierService{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private IShowDao showDao;
	
	private Panier panier = new Panier();
	private List<Show> lstShows;
	private int cptAdded = 0;
	private int cptRemoved = 0;
	private int cptReserve = 0;
	private int represBilletReserve = 0;
	private int nbItemsPanier;
	private final int LIMITE_TICKET = 6;
	
	public PanierServiceImpl() { }
	
	
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
		//lstShows = showDao.getAllShows();
		if (lstShows == null || lstShows.size() <= 0) {
			lstShows = showDao.getAllShows();
		}
		List<Ticket>lstBillet = lstShows.get(billetPanier.getIdSpectacle()-1).getRepresentations().get(billetPanier.getIdRepresentation()).getBillets();
		//lstShows.get(billetPanier.getIdSpectacle()).getRepresentations().get(billetPanier.getIdRepresentation()).setBilletReserve(cptReserve);		
		//represBilletReserve = lstShows.get(billetPanier.getIdSpectacle()).getRepresentations().get(billetPanier.getIdRepresentation()).getBilletReserve();
		cptAdded=0;
		int panierCheck=nbItemsPanier+billetPanier.getNbBillets();
		
		for(Ticket ticket:lstBillet){
			if(ticket.getState().equals(State.RESERVED)){
				cptReserve++;
			}
		}
		
		if(panierCheck<=LIMITE_TICKET){
		
		for (int i = 0; i < lstBillet.size(); i++) {
			
			
					if(lstBillet.get(i).getState().equals(State.AVAILABLE)){
					
					if(nbItemsPanier<=cptReserve){
						nbItemsPanier+=1;
						lstBillet.get(i).setState(State.RESERVED);
						//sessionFactory.getCurrentSession().update(lstBillet);
						cptAdded++;
						cptReserve++;
						//nbItemsPanier +=cptAdded;
						//panier.getLstBilletPanier().add(billetPanier); 
						//nbItemsPanier+=billetPanier.getNbBillets();
						//lstShows.get(billetPanier.getIdSpectacle()).getRepresentations().get(billetPanier.getIdRepresentation()).setBilletReserve(cptReserve++);
						}
					}
				
				/*else{
					if(nbItemsPanier<=cptReserve){
						lstBillet.get(i).setState(State.Reserve);
						cptAdded++;
						cptReserve++;
						//lstShows.get(billetPanier.getIdSpectacle()).getRepresentations().get(billetPanier.getIdRepresentation()).setBilletReserve(cptReserve++);
					}*/
				

			if(cptAdded==billetPanier.getNbBillets()&&nbItemsPanier<=LIMITE_TICKET){
				panier.getLstBilletPanier().add(billetPanier); 
				//nbItemsPanier+=billetPanier.getNbBillets();
				break;
				}
			}
			
			}
		}
		
	
	
	

	@Override
	public void delete(int idSpectacle,int idRepresentation, int indexPanier) {
		if (lstShows == null || lstShows.size() <= 0) {
			lstShows = showDao.getAllShows();
		}
		int cpt =0;
		cptRemoved=0;
		//lstShows = showDao.getAllShows();
		List<Ticket>lstBillet = lstShows.get(idSpectacle).getRepresentations().get(idRepresentation).getBillets();
		
		
		
		for(int i=0;i<lstBillet.size();i++){
			if(lstBillet.get(i).getState().equals(State.RESERVED)){
				lstBillet.get(i).setState(State.AVAILABLE);
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
		if (lstShows == null || lstShows.size() <= 0) {
			lstShows = showDao.getAllShows();
		}
		List<Ticket>lstBillet = lstShows.get(idSpectacle).getRepresentations().get(idRepresentation).getBillets();
		for(int i=0;i<lstBillet.size();i++){
			if(lstBillet.get(i).getState().equals(State.RESERVED)){
				lstBillet.remove(i);
				
			}
		}
	}
	
	public void deleteAll() {
		if (lstShows == null || lstShows.size() <= 0) {
			lstShows = showDao.getAllShows();
		}
		for (Show show : lstShows) {
			for (Representation representation : lstShows.get(show.getId()).getRepresentations()) {
				for (Ticket billet : representation.getBillets()) {

					if (billet.getState().equals(State.RESERVED)) {
						billet.setState(State.SOLD);

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
