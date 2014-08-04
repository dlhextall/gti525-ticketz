package ca.etsmtl.ticketz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import ca.etsmtl.ticketz.service.IShowService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends AbstractController {

	private static final Logger LOGGER = Logger.getLogger(HomeController.class);
	@Autowired
	private IShowService provider;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest _req, HttpServletResponse _resp) throws Exception {
		ModelAndView model = new ModelAndView("home");
		model.addObject("spectacles", provider.getFeaturedShows());
		return model;
	}
	
}
