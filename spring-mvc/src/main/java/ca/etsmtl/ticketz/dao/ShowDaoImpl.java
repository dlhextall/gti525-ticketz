package ca.etsmtl.ticketz.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ca.etsmtl.ticketz.model.Show;

public class ShowDaoImpl implements IShowDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	@Transactional
	public List<Show> getAllShows() {
		Session session = sessionFactory.getCurrentSession();
		List<Show> shows = (List<Show>) session.createQuery("from Show").list();
		return shows;
	}

	@Override
	@Transactional
	public Show getShowAt(int id) {
		Session session = sessionFactory.getCurrentSession();
		Show show = (Show) session.get(Show.class, id);
		return show;
	}

	@Override
	@Transactional
	public List<Show> getFeaturedShows() {
		Session session = sessionFactory.getCurrentSession();
		List<Show> shows = (List<Show>) session.createQuery("from Show where featured=true").list();
		return shows;
	}

	@Override
	@Transactional
	public List<Show> getShowsMatching(String _criteria) {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<Show> matchingShows = new ArrayList<Show>();
		for (Show show : (List<Show>) session.createQuery("from Show").list()) {
			if (show.getName().toLowerCase().contains(_criteria.toLowerCase()) || show.getDescription().toLowerCase().contains(_criteria.toLowerCase())) {
				matchingShows.add(show);
			}
		}
		return matchingShows;
	}
	
}
