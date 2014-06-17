package ca.etsmtl.ticketz.controller;

import java.util.ArrayList;

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
	TicketzProvider ticketz;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	/*public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView model = new ModelAndView("home");
		ArrayList<Show> spectacles = TicketzProvider.getData();
		model.addObject(spectacles);
		model.addObject("spectacles", spectacles);
		
		return model;
	}
	
}
