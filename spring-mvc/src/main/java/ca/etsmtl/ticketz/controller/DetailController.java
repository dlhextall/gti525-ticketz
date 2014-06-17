package ca.etsmtl.ticketz.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ca.etsmtl.ticketz.dao.TicketzProvider;
import ca.etsmtl.ticketz.model.Show;


@Controller
public class DetailController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("id") String id,Locale locale, Model model) {
		Show spectacle = TicketzProvider.getDataAt(Integer.parseInt(id));
		model.addAttribute("spectacle",spectacle);
		return "Detail";
	}
}
