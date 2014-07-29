package ca.etsmtl.ticketz.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ca.etsmtl.ticketz.model.Show;
import ca.etsmtl.ticketz.service.TicketzProvider;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Controller
public class SearchResultController {
	
	@Autowired
	TicketzProvider provider = null;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/searchResult", method = RequestMethod.GET)
	public String detail(Locale locale, Model model) {		
		model.addAttribute("spectacles", provider.getAllShows());
		return "SearchResult";
	}
}
