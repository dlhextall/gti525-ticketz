package ca.etsmtl.ticketz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ca.etsmtl.ticketz.exception.ShowNotFoundException;
import ca.etsmtl.ticketz.service.IShowService;


@Controller
public class DetailController {
	
	private static final Logger LOGGER = Logger.getLogger(DetailController.class);
	@Autowired
	private IShowService provider;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)

	protected ModelAndView handleRequestInternal(@PathVariable("id") int _showId, HttpServletRequest _req, HttpServletResponse _resp) throws Exception {
		ModelAndView model;
		try {
			model = new ModelAndView("Detail");
			model.addObject("spectacle", provider.getShowAt(_showId));
			return model;
		} catch (ShowNotFoundException e) {
			model = new ModelAndView("redirect:/404");
			return model;
		}
	}
}
