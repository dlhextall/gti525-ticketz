package ca.etsmtl.ticketz.service;

import ca.etsmtl.ticketz.model.BilletPanier;
import ca.etsmtl.ticketz.model.Show;

public interface IService {
	void add(BilletPanier billet);
	void delete(int index);
}
