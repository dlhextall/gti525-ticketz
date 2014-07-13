package ca.etsmtl.ticketz.session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.service.PanierService;

public class SessionManager implements HttpSessionListener {

	private PanierService service;
	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		//HttpSession session = sessionEvent.getSession();
		//session.setAttribute("panier", "allo");
		//session.setMaxInactiveInterval(1200);
		service = new PanierService();
		sessionEvent.getSession().setAttribute("panier",service.getPanier());
		sessionEvent.getSession().setMaxInactiveInterval(1);
		System.out.println("session created");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
