package ca.etsmtl.ticketz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import ca.etsmtl.ticketz.dao.TicketzProvider;
import ca.etsmtl.ticketz.model.Show;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends AbstractController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	Timer timer;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest _req, HttpServletResponse _resp) throws Exception {
		ModelAndView model = new ModelAndView("home");
		model.addObject("spectacles", TicketzProvider.getFeaturedShows());
		
		return model;
	}
	

	
	      
	
	
}
