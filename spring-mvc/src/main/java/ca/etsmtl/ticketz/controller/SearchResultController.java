package ca.etsmtl.ticketz.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.etsmtl.ticketz.model.Show;
import ca.etsmtl.ticketz.service.IShowService;
import ca.etsmtl.ticketz.service.TicketzProvider;

@Controller
public class SearchResultController {
	
	@Autowired
	private IShowService provider;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/searchResult", method = RequestMethod.GET)
	public String detail(Locale locale, Model model) {	
		List<Show> shows = (List<Show>) provider.getAllShows();
		model.addAttribute("spectacles", shows);
		return "SearchResult";
	}
}
