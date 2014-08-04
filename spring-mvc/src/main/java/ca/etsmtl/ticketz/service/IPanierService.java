package ca.etsmtl.ticketz.service;

import java.util.List;

import ca.etsmtl.ticketz.model.LignePanier;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.model.Show;

public interface IPanierService {
	public void add(LignePanier billet);
	public void delete(int idSpectacle,int idRepresentation, int indexPanier);
	public void deleteFinal(int idSpectacle,int idRepresentation, int indexPanier);
	public void deleteCart();
	public Panier getPanier();
	public void setPanier(Panier _panier);
	public List<LignePanier> getAllBilletPanier();
	public void setCptAdded(int _cpt);
	public void setCptReserve(int _cpt);
	public void setNbItemsPanier(int _cpt);
}
