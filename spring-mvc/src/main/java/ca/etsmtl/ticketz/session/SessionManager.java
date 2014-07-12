package ca.etsmtl.ticketz.session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ca.etsmtl.ticketz.model.Panier;

public class SessionManager implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		//HttpSession session = sessionEvent.getSession();
		//session.setAttribute("panier", "allo");
		//session.setMaxInactiveInterval(1200);
		sessionEvent.getSession().setMaxInactiveInterval(30);
		System.out.println("session created");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
