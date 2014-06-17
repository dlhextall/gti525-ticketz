package ca.etsmtl.ticketz.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ca.etsmtl.ticketz.dao.TicketzProvider;
import ca.etsmtl.ticketz.model.Show;

@Controller
public class SpectacleController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/spectacle", method = RequestMethod.GET)
	public String detail(Locale locale, Model model) {		
		ArrayList<Show> spectacles = TicketzProvider.getAllShows();
		model.addAttribute("spectacles",spectacles);		
		return "Spectacle";
	}
}
