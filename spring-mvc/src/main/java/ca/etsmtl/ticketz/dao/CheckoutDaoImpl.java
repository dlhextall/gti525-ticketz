package ca.etsmtl.ticketz.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ca.etsmtl.ticketz.model.Client;
import ca.etsmtl.ticketz.model.ClientOrder;

public class CheckoutDaoImpl implements ICheckoutDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addClient(Client _client) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		session.save(_client);
	}

	@Override
	public void addClientOrder(ClientOrder _clientOrder) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		session.save(_clientOrder);
	}

}
