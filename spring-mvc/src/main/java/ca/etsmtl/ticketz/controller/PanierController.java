package ca.etsmtl.ticketz.controller;

import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PanierController{

	@RequestMapping(value = "/panier", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "panier";
	}
}
