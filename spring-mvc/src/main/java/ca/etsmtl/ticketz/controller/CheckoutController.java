package ca.etsmtl.ticketz.controller;

import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

import java.io.StringReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;










import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import ca.etsmtl.ticketz.form.CheckoutForm;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.service.ICheckoutService;
import ca.etsmtl.ticketz.service.PaiementStub;
import ca.etsmtl.ticketz.service.PanierServiceImpl;



/**
 * Handles requests for the application home page.
 */
@Controller
public class CheckoutController {
	
	private static final Logger logger = Logger.getLogger(CheckoutController.class);
	private static final String API_KEY = "ea657f99f7511a9bf170";
	
	PanierServiceImpl pService = PanierServiceImpl.getInstance();
	@Autowired
	ICheckoutService checkoutService;
	@Autowired
	IPaiementDAO paiementDao;
	
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
	public ModelAndView checkoutPOSTREST(@Validated @ModelAttribute("checkoutForm") CheckoutForm _checkoutForm, BindingResult _res, HttpServletRequest _req) {
		ModelAndView model;
		
//		Errors in checkout form
		if (_res.hasErrors()) {			 
			model = new ModelAndView("redirect:/checkout");
			model.addObject("errors", _res.getAllErrors());
			logger.error("CheckoutForm has errors");
			for (ObjectError err : _res.getAllErrors()) {
				logger.error("CheckoutForm error : " + err);
			}
			return model;
		}
		
		HttpSession session = _req.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		model = new ModelAndView("redirect:/");
		
		InformationsPaiementTO paiementInfo = new InformationsPaiementTO();
		paiementInfo.setAmount(panier.getPrixTotal());
		paiementInfo.setApi_key(API_KEY);
		paiementInfo.setCard_number(Long.parseLong(_checkoutForm.getCcNumber()));
		paiementInfo.setLast_name(_checkoutForm.getCcLastName());
		paiementInfo.setFirst_name(_checkoutForm.getCcFirstName());
		paiementInfo.setMonth(Integer.parseInt(_checkoutForm.getCcMonth()));
		paiementInfo.setYear(Integer.parseInt(_checkoutForm.getCcYear()));
		paiementInfo.setSecurity_code(Integer.parseInt(_checkoutForm.getCcCVC()));
		paiementInfo.setOrder_id(1);
		paiementInfo.setStore_id(1);
		
		ReponseSystemePaiementTO reponsePreauth = paiementDao.effectuerPreauthorisation(paiementInfo);
		
		try {
			RequeteAuthorisationTO requeteAuthorisationTO = new RequeteAuthorisationTO();
			requeteAuthorisationTO.setApi_key(API_KEY);
			requeteAuthorisationTO.setStore_id(paiementInfo.getStore_id());
			requeteAuthorisationTO.setTransaction_id(reponsePreauth.getTransactionId());
			
			ReponseSystemePaiementTO reponseApprouver = paiementDao.approuverTransaction(requeteAuthorisationTO);
			
			checkoutService.processClientOrder(_checkoutForm);
			logger.info("-----------------CONFIRMATION ACHAT-----------------");
			logger.info(reponseApprouver.getStatus());
			logger.info("----------------/CONFIRMATION ACHAT-----------------");
		} catch (Exception e) {
			logger.error("Transaction failed : " + e.getMessage());
		}
		
		return model;
	}
}
