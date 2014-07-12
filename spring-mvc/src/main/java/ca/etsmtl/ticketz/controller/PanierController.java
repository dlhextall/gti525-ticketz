package ca.etsmtl.ticketz.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.mina.filter.reqres.Request;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PanierController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private PanierService service;
	
	@RequestMapping(value = "/panier", method = RequestMethod.GET)
	public String panier(HttpSession session,Locale locale, Model model) {		
		//HttpSession session = null;
		//session.setAttribute("panier", "test");
		//model.addAttribute("panier", service.getInstance().getPanier());
		//session.invalidate();
		
		return "Panier";
		
	}

}
