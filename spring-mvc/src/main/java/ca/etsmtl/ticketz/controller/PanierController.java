package ca.etsmtl.ticketz.controller;

import java.math.BigDecimal;
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

import ca.etsmtl.ticketz.model.LignePanier;
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
		service.setPanier(panier);
		List<LignePanier> billets =  service.getAllBilletPanier();					
		model.addAttribute("billets", billets);
		model.addAttribute("panier",panier);
	
		return "Panier";
		
	}


	@RequestMapping(value = "/panier/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request,Locale locale, Model model) {
		HttpSession session = request.getSession();
		Panier panier = (Panier)session.getAttribute("panier");
		service.setPanier(panier);
		
		LignePanier billetPanier = new LignePanier();
		if(request.getParameter("nbTickets") != null){
			billetPanier.setNbBillets(Integer.parseInt(request.getParameter("nbTickets")));
			billetPanier.setMontantUnitaire(new BigDecimal(request.getParameter("unityPrice")));
			billetPanier.setIdRepresentation(0);
			billetPanier.setNomSpectacle(request.getParameter("nomSpectacle"));
			billetPanier.setIdSpectacle(Integer.parseInt(request.getParameter("idSpectacle")));
		}		
		
		service.add(billetPanier);
		
		List<LignePanier> billets =  service.getAllBilletPanier();					
		model.addAttribute("billets", billets);
		model.addAttribute("panier", service.getPanier());	
		
		session.setAttribute("panier", service.getPanier());
		return "Panier";
		
	}
	
	@RequestMapping(value = "/panier/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model){
		Panier panier = service.getPanier();
		if(request.getParameter("id") != null){			
			HttpSession session = request.getSession();
			panier = (Panier)session.getAttribute("panier");		
			service.setPanier(panier);
			service.delete(Integer.parseInt(request.getParameter("idS")),Integer.parseInt(request.getParameter("idR")),Integer.parseInt(request.getParameter("id")));
			
		}
		
		List<LignePanier> billets =  service.getAllBilletPanier();					
		model.addAttribute("billets", billets);
		model.addAttribute("panier",panier);
		
		return "Panier";
	}
}
