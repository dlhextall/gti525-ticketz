package ca.etsmtl.ticketz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ca.etsmtl.ticketz.model.Client;
import ca.etsmtl.ticketz.model.ClientOrder;

public class CheckoutDaoImpl implements ICheckoutDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	@Transactional
	public void addClient(Client _client) {
		Session session = sessionFactory.getCurrentSession();
		session.save(_client);
	}

	@Override
	@Transactional
	public void addClientOrder(ClientOrder _clientOrder) {
		Session session = sessionFactory.getCurrentSession();
		session.save(_clientOrder);
	}

}
