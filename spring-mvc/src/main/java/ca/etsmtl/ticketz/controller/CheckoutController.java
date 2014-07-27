package ca.etsmtl.ticketz.controller;

import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;







import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ca.etsmtl.ticketz.form.CheckoutForm;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.service.IPaiementStub;
import ca.etsmtl.ticketz.service.PanierService;



/**
 * Handles requests for the application home page.
 */
@Controller
public class CheckoutController {
	private static final Logger logger = Logger.getLogger(CheckoutController.class);
	
	PanierService pService = PanierService.getInstance();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout(HttpServletRequest _req) {
		ModelAndView model = new ModelAndView("checkout");
		model.addObject("checkoutForm", new CheckoutForm());
//		List<ObjectError> errors = (List<ObjectError>) _req.getAttribute("errors");
//		if (errors != null && errors.size() > 0) {
//			log.log(Priority.ERROR, "Errors in checkout form");
//		}
		return model;
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ModelAndView checkoutPOST(@Validated @ModelAttribute("checkoutForm") CheckoutForm _checkoutForm, BindingResult _res, HttpServletRequest _req) {
		ModelAndView model;
		
//		Errors in checkout form
		if (_res.hasErrors()) {			 
			model = new ModelAndView("redirect:/checkout");
			model.addObject("errors", _res.getAllErrors());
//			_req.setAttribute("errors", _res.getAllErrors());
			return model;
		}
		
		HttpSession session = _req.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		model = new ModelAndView("redirect:/");
		
		IPaiementStub paiement = new IPaiementStub();
		
		InformationsPaiementTO paiementInfo = new InformationsPaiementTO();
		paiementInfo.setAmount(panier.getPrixTotal());
//		paiementInfo.setApi_key(api_key);
		paiementInfo.setCard_number(Long.parseLong(_checkoutForm.getCcNumber()));
		paiementInfo.setLast_name(_checkoutForm.getCcLastName());
		paiementInfo.setFirst_name(_checkoutForm.getCcFirstName());
		paiementInfo.setMonth(Integer.parseInt(_checkoutForm.getCcMonth()));
		paiementInfo.setYear(Integer.parseInt(_checkoutForm.getCcYear()));
		paiementInfo.setSecurity_code(Integer.parseInt(_checkoutForm.getCcCVC()));
//		paiementInfo.setOrder_id(order_id);
//		paiementInfo.setStore_id(store_id);
		
		ReponseSystemePaiementTO reponsePreauthorisation = paiement.effectuerPreauthorisation(paiementInfo);
		if (reponsePreauthorisation.getCode() / 100 == 2) {
			RequeteAuthorisationTO requete = new RequeteAuthorisationTO();
			requete.setApi_key(paiementInfo.getApi_key());
			requete.setStore_id(paiementInfo.getStore_id());
//			requete.setTransaction_id();
			ReponseSystemePaiementTO reponseApprouver = paiement.approuverTransaction(requete);
//			Succès
			if (reponseApprouver.getCode() / 100 == 2) {
				
				logger.info("-----------------CONFIRMATION ACHAT-----------------");
				StringBuffer log = new StringBuffer();
				log.append(_checkoutForm.toString());
				logger.info(log.toString());
				logger.info("----------------------------------------------------");
				pService.deleteAll();
				session.invalidate();
			} else {
				model.setViewName("redirect:/checkout");
			}
			
		} else {
			model.setViewName("redirect:/checkout");
		}
		
		
		return model;
	}
	
}
