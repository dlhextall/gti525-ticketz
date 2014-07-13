package ca.etsmtl.ticketz.controller;

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

import ca.etsmtl.ticketz.model.Panier;
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
		//HttpSession session = null;
		Panier panier = service.getPanier();
		HttpSession session = request.getSession();
		panier = (Panier)session.getAttribute("panier");
		
		model.addAttribute("panier",panier);
		return "Panier";
		
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request,Locale locale, Model model) {		
		HttpSession session = request.getSession();
		Panier test = (Panier)session.getAttribute("panier");
		test.setSousTotal(100);
		model.addAttribute("panier", test);
		
		//model.addAttribute("panier", service.getInstance().getPanier());
		
		
		
		return "Panier";
		
	}
	
}
