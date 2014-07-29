package ca.etsmtl.ticketz.service;

import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

public class PaiementStub implements IPaiementDAO {

	@Override
	public ReponseSystemePaiementTO approuverTransaction(
			RequeteAuthorisationTO arg0) {
		ReponseSystemePaiementTO reponse = new ReponseSystemePaiementTO();
		reponse.setCode(200);
		reponse.setMessage("Transaction approuvée");
		reponse.setTransactionId((int) arg0.getTransaction_id());
		
		return reponse;
	}

	@Override
	public ReponseSystemePaiementTO effectuerPreauthorisation(
			InformationsPaiementTO arg0) {
		ReponseSystemePaiementTO reponse = new ReponseSystemePaiementTO();
		reponse.setCode(200);
		reponse.setMessage("Transaction préapprouvée");
		
		return reponse;
	}

}
