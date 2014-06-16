package ca.etsmtl.ticketz.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpectacleController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/spectacle", method = RequestMethod.GET)
	public String detail(Locale locale, Model model) {		
		return "Spectacle";
	}
}
