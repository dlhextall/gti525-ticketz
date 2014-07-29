package ca.etsmtl.ticketz.dao;

import ca.etsmtl.ticketz.model.Client;
import ca.etsmtl.ticketz.model.ClientOrder;

public interface ICheckoutDao {
	
	public void addClient(Client _client);
	public void addClientOrder(ClientOrder _clientOrder);
	
}
