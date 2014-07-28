package ca.etsmtl.ticketz.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import ca.etsmtl.ticketz.dao.TicketzProvider;
import ca.etsmtl.ticketz.model.Show;


@Controller
public class DetailController extends AbstractController {
	
	@Autowired
	private TicketzProvider provider = null;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest _req, HttpServletResponse _resp) throws Exception {
		ModelAndView model;
		String idStr = _req.getParameter("id");
		try {
			model = new ModelAndView("Detail");
			int id = Integer.parseInt(idStr);
			model.addObject("spectacle", provider.getShowAt(id));
			return model;
		} catch (NumberFormatException _e) {
			model = new ModelAndView("redirect:/");
			model.addObject("spectacles", provider.getFeaturedShows());
			return model;
		}
	}
}
