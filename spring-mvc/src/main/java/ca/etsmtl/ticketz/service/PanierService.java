package ca.etsmtl.ticketz.service;

import org.springframework.stereotype.Service;

import ca.etsmtl.ticketz.data.BilletBank;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.model.Show;
@Service("service")
public class PanierService implements IService{
	private Panier panier;
	/*private static PanierService instance = null;
	
	public static PanierService getInstance() {
		if (instance == null) {
			instance = new PanierService();
		}
		return instance;
	}*/
	public PanierService(){
		panier = new Panier();
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	@Override
	public void add(Show show) {
		
		
	}

}
