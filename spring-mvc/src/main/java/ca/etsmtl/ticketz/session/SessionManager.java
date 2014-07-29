package ca.etsmtl.ticketz.session;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ca.etsmtl.ticketz.data.ShowBank;
import ca.etsmtl.ticketz.model.Ticket;
import ca.etsmtl.ticketz.model.Ticket.State;
import ca.etsmtl.ticketz.model.LignePanier;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.model.Show;
import ca.etsmtl.ticketz.service.PanierServiceImpl;

public class SessionManager implements HttpSessionListener {

	private PanierServiceImpl service = PanierServiceImpl.getInstance();
	private List<Show> spectacle = ShowBank.getInstance().getShows();

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		//HttpSession session = sessionEvent.getSession();
		//session.setAttribute("panier", "allo");
		//session.setMaxInactiveInterval(1200);
		service.setPanier(new Panier());
		sessionEvent.getSession().setAttribute("panier",service.getPanier());
		sessionEvent.getSession().setAttribute("billets", service.getAllBilletPanier());
		sessionEvent.getSession().setMaxInactiveInterval(120);
		System.out.println("session created");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		// TODO Auto-generated method stub
		if(sessionEvent.getSession().getAttribute("panier")!=null){
			int cptRestored=0;
			Panier panier = (Panier)sessionEvent.getSession().getAttribute("panier");
			List<LignePanier> billetPanier = panier.getLstBilletPanier();
			
			
			
			
			
			for(int i=0;i<billetPanier.size();i++){
				List<Ticket>lstBillet = spectacle.get(billetPanier.get(i).getIdSpectacle()).getRepresentations().get(billetPanier.get(i).getIdRepresentation()).getBillets();
				
				for(int j=0;j<lstBillet.size();j++){
					if(lstBillet.get(j).getState().equals(State.RESERVED)){
						lstBillet.get(j).setState(State.AVAILABLE);
						//cptRestored++;
					}
					//spectacle.get(billetPanier.get(i).getIdSpectacle()).getRepresentations().get(billetPanier.get(i).getIdRepresentation()).setBilletReserve(0);
					//if(cptRestored==billetPanier)
					
				}
			}
			
		}
		service.deleteCart();
		service.setCptAdded(0);
		service.setCptReserve(0);
		service.setNbItemsPanier(0);
		System.out.println("Session Timer Current time is :: "+ new Date());
		
	}

}
