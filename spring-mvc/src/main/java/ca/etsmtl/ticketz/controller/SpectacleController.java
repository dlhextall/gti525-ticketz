package ca.etsmtl.ticketz.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.etsmtl.ticketz.model.Show;
import ca.etsmtl.ticketz.service.TicketzProvider;

@Controller
public class SpectacleController {
	
	@Autowired
	private TicketzProvider provider = null;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/spectacle", method = RequestMethod.GET)
	public String detail(Locale locale, Model model) {		
		List<Show> spectacles = provider.getAllShows();
		model.addAttribute("spectacles",spectacles);		
		return "Spectacle";
	}
}
