package ca.etsmtl.ticketz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.mina.filter.reqres.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import ca.etsmtl.ticketz.model.BilletPanier;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.model.Show;
import ca.etsmtl.ticketz.service.IService;
import ca.etsmtl.ticketz.service.PanierService;

@Controller
@SessionAttributes("panier")
public class PanierController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private PanierService service = new PanierService();
	
	
	@RequestMapping(value = "/panier", method = RequestMethod.GET)
	public String panier(HttpServletRequest request,Locale locale, Model model) {		
		Panier panier = service.getPanier();
		HttpSession session = request.getSession();
		panier = (Panier)session.getAttribute("panier");
		
		model.addAttribute("panier",panier);
		
		return "Panier";
		
	}


	@RequestMapping(value = "/panier/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request,Locale locale, Model model) {
		
		BilletPanier billetPanier = new BilletPanier();
		if(request.getParameter("nbTickets") != null){
			billetPanier.setNbBillets(Integer.parseInt(request.getParameter("nbTickets")));
			billetPanier.setMontantTotal(Integer.parseInt(request.getParameter("totalPrice")));
			billetPanier.setIdRepresentation(0);
			billetPanier.setNomSpectacle("Whaddup bitches");
			billetPanier.setIdSpectacle(Integer.parseInt(request.getParameter("idSpectacle")));
		}
				
		HttpSession session = request.getSession();
		Panier panier = (Panier)session.getAttribute("panier");
		service.setPanier(panier);
		service.add(billetPanier);
		
		List<BilletPanier> billets =  service.getAllBilletPanier();
					
		model.addAttribute("billets", billets);
		model.addAttribute("panier", service.getPanier());	
		
		session.setAttribute("panier", service.getPanier());
		return "Panier";
		
	}
	
	@RequestMapping(value = "/panier/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model){
		
		
		return "Panier";
	}
}
