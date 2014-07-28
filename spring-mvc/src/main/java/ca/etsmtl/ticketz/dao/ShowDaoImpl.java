package ca.etsmtl.ticketz.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ca.etsmtl.ticketz.model.Show;

public class ShowDaoImpl implements IShowDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public ShowDaoImpl() {
		
	}
	

	@Override
	public List<Show> getAllShows() {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return (List<Show>) session.createQuery("from Show").list();
	}

	@Override
	public Show getShowAt(int id) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return (Show) session.get(Show.class, id);
	}

	@Override
	public List<Show> getFeaturedShows() {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return (List<Show>) session.createQuery("from Show where featured=true").list();
	}

	@Override
	public List<Show> getShowsMatching(String _criteria) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		ArrayList<Show> matchingShows = new ArrayList<Show>();
		for (Show show : (List<Show>) session.createQuery("from Show").list()) {
			if (show.getName().toLowerCase().contains(_criteria.toLowerCase()) || show.getDescription().toLowerCase().contains(_criteria.toLowerCase())) {
				matchingShows.add(show);
			}
		}
		return matchingShows;
	}

	

}
