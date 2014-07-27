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
	
	//@RequestMapping(value = "/checkout", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ModelAndView checkoutPOSTREST(@Validated @ModelAttribute("checkoutForm") CheckoutForm _checkoutForm, BindingResult _res, HttpServletRequest _req){
		RestTemplate restTemplate = new RestTemplate();
		ModelAndView model;
		String transactionId;
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
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("api_key", "ea657f99f7511a9bf170");
		vars.put("store_id", "1");
		vars.put("order_id", "1");
		vars.put("first_name", _checkoutForm.getCcFirstName());
		vars.put("last_name", _checkoutForm.getCcLastName());
		vars.put("card_number", _checkoutForm.getCcNumber());
		vars.put("security_code", _checkoutForm.getCcCVC());
		vars.put("year", _checkoutForm.getCcYear());
		vars.put("month", _checkoutForm.getCcMonth());
		vars.put("amount", panier.getPrixTotal().toString());
		
		String url = "http://gti525.herokuapp.com/transactions.xml?api_key={api_key}&store_id={store_id}&order_id={order_id}"+
						"&first_name={first_name}&last_name={last_name}&card_number={card_number}&security_code={security_code}"+
						"&year={year}&month={month}&amount={amount}";

		String result = restTemplate.postForObject(url, null, String.class, vars);
		System.out.println(result);
		
		try {
			transactionId= getTransactionId(result);
			Map<String, String> varsAuth = new HashMap<String, String>();
			varsAuth.put("api_key", "ea657f99f7511a9bf170");
			varsAuth.put("store_id", "1");
			System.out.println(transactionId);
			String urlAuth = "http://gti525.herokuapp.com/transactions/"+Integer.parseInt(transactionId)+".xml?api_key={api_key}&store_id={store_id}";
			String resultAuth = restTemplate.getForObject(urlAuth, String.class, varsAuth);
			System.out.println(resultAuth);
		} catch (Exception e) {
			
			System.out.println("Transaction Failed");
			//e.printStackTrace();
		}
		
		
		
		return model;
	}
	
	public String getTransactionId(String xml) throws Exception{
		String id="";
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    InputSource is = new InputSource();
	    is.setCharacterStream(new StringReader(xml));
	    
	    Document doc = db.parse(is);
	    NodeList nodes = doc.getElementsByTagName("order");
	    for (int i = 0; i < nodes.getLength(); i++) {
	    	Element element = (Element) nodes.item(i);
	    	NodeList transactionId = element.getElementsByTagName("transaction-id");
	        Element line = (Element) transactionId.item(0);
	        id= getCharacterDataFromElement(line);
	    }
	    	if(!id.equals(null)){
	    		return id;
	    	}
		
		return "";
	}
	
	 public static String getCharacterDataFromElement(Element e) {
		    Node child = e.getFirstChild();
		    if (child instanceof CharacterData) {
		      CharacterData cd = (CharacterData) child;
		      return cd.getData();
		    }
		    return "";
		  }
}
