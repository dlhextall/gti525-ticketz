package ca.etsmtl.ticketz.session;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ca.etsmtl.ticketz.data.ShowBank;
import ca.etsmtl.ticketz.model.Billet;
import ca.etsmtl.ticketz.model.Billet.Etat;
import ca.etsmtl.ticketz.model.BilletPanier;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.model.Show;
import ca.etsmtl.ticketz.service.PanierService;

public class SessionManager implements HttpSessionListener {

	private PanierService service;
	private List<Show> spectacle = ShowBank.getInstance().getShows();

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		//HttpSession session = sessionEvent.getSession();
		//session.setAttribute("panier", "allo");
		//session.setMaxInactiveInterval(1200);
		service = new PanierService();
		sessionEvent.getSession().setAttribute("panier",service.getPanier());
		sessionEvent.getSession().setMaxInactiveInterval(60);
		System.out.println("session created");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		// TODO Auto-generated method stub
		if(sessionEvent.getSession().getAttribute("panier")!=null){
			int cptRestored=0;
			Panier panier = (Panier)sessionEvent.getSession().getAttribute("panier");
			List<BilletPanier> billetPanier = panier.getLstBilletPanier();
			
			
			
			
			
			for(int i=0;i<billetPanier.size();i++){
				List<Billet>lstBillet = spectacle.get(billetPanier.get(i).getIdSpectacle()).representations.get(billetPanier.get(i).getIdRepresentation()).getBillets();
				
				for(int j=0;j<lstBillet.size();j++){
					if(lstBillet.get(j).getEtat().equals(Etat.Reserve)){
						lstBillet.get(j).setEtat(Etat.EnVente);
						//cptRestored++;
					}
					spectacle.get(billetPanier.get(i).getIdSpectacle()).representations.get(billetPanier.get(i).getIdRepresentation()).setBilletReserve(0);
					//if(cptRestored==billetPanier)
					
				}
			}
			
		}
		
		
	}

}
