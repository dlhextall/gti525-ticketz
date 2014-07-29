package ca.etsmtl.ticketz.controller;

import java.math.BigDecimal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ca.etsmtl.ticketz.model.LignePanier;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.service.PanierServiceImpl;

@Controller
@SessionAttributes("panier")
public class PanierController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private PanierServiceImpl service = PanierServiceImpl.getInstance();
	private static final Logger log = Logger.getLogger(PanierController.class.getName());
	
	
	
	@RequestMapping(value = "/panier", method = RequestMethod.GET)
	public String panier(HttpServletRequest request,Locale locale, Model model) {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		if (panier == null) {
			panier = new Panier();
		}
		service.setPanier(panier);				
		session.setAttribute("billets", service.getAllBilletPanier());
		session.setAttribute("panier", panier);
	
		return "Panier";
		
	}


	@RequestMapping(value = "/panier/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request,Locale locale, Model model) {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		if (panier == null) {
			panier = new Panier();
		}
		service.setPanier(panier);
		
		if(request.getParameter("nbTickets") != null){
			LignePanier billetPanier = new LignePanier();
			billetPanier.setNbBillets(Integer.parseInt(request.getParameter("nbTickets")));
			billetPanier.setMontantUnitaire(new BigDecimal(request.getParameter("unityPrice")));
			billetPanier.setIdRepresentation(0);
			billetPanier.setNomSpectacle(request.getParameter("nomSpectacle"));
			billetPanier.setIdSpectacle(Integer.parseInt(request.getParameter("idSpectacle")));		
			service.add(billetPanier);
			
			session.setAttribute("billets", service.getAllBilletPanier());
			session.setAttribute("panier", service.getPanier());
		}
		
		return "Panier";
		
	}
	
	@RequestMapping(value = "/panier/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		if (request.getParameter("id") != null) {
			HttpSession session = request.getSession();
			Panier panier = (Panier) session.getAttribute("panier");	
			if (panier == null) {
				panier = new Panier();
			}
			service.setPanier(panier);
			service.delete(Integer.parseInt(request.getParameter("idS")),Integer.parseInt(request.getParameter("idR")),Integer.parseInt(request.getParameter("id")));

			session.setAttribute("billets", service.getAllBilletPanier());
			session.setAttribute("panier", panier);
		}
		
		return "Panier";
	}
}
