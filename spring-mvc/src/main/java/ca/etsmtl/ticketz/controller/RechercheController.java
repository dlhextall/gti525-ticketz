package ca.etsmtl.ticketz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import ca.etsmtl.ticketz.service.IShowService;

@Controller
public class RechercheController extends AbstractController {
	
	@Autowired
	private IShowService provider;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/recherche", method = RequestMethod.GET)
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest _req, HttpServletResponse _resp) throws Exception {
		ModelAndView model;
		
		String criteria = _req.getParameter("criteria");
		if (criteria != null && !criteria.isEmpty()) {
			model = new ModelAndView("Recherche");
			model.addObject("results", provider.getMatchingShows(criteria));
			model.addObject("criteria", criteria);
		} else {
			model = new ModelAndView("redirect:/");
			model.addObject("spectacles", provider.getFeaturedShows());
		}
		
		return model;
	}
}
