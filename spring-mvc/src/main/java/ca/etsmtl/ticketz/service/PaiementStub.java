package ca.etsmtl.ticketz.service;

import org.apache.log4j.Logger;

import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

public class PaiementStub implements IPaiementDAO {
	
	private static final Logger logger = Logger.getLogger(PaiementStub.class);

	@Override
	public ReponseSystemePaiementTO approuverTransaction(RequeteAuthorisationTO _req) {
		ReponseSystemePaiementTO reponse = new ReponseSystemePaiementTO();
		reponse.setCode(200);
		reponse.setMessage("Completed");
		reponse.setTransactionId((int) _req.getTransaction_id());
		
		return reponse;
	}

	@Override
	public ReponseSystemePaiementTO effectuerPreauthorisation(InformationsPaiementTO _info) {
		ReponseSystemePaiementTO reponse = new ReponseSystemePaiementTO();
		reponse.setCode(200);
		reponse.setMessage("Approved");
		reponse.setTransactionId(1);
		
		return reponse;
	}

}
