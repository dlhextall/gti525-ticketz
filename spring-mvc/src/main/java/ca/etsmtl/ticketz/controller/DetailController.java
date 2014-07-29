package ca.etsmtl.ticketz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import ca.etsmtl.ticketz.exceptions.ShowNotFoundException;
import ca.etsmtl.ticketz.service.TicketzProvider;


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
			int id = Integer.parseInt(idStr);
			try {
				model = new ModelAndView("Detail");
				model.addObject("spectacle", provider.getShowAt(id));
				return model;
			} catch (ShowNotFoundException e) {
				model = new ModelAndView("redirect:/404");
				return model;
			}
		} catch (NumberFormatException _e) {
			model = new ModelAndView("redirect:/404");
			return model;
		}
	}
}
