package ca.etsmtl.ticketz.service;

import ca.etsmtl.ticketz.model.LignePanier;
import ca.etsmtl.ticketz.model.Show;

public interface IService {
	void add(LignePanier billet);
	void delete(int idSpectacle,int idRepresentation, int indexPanier);
}
