package ca.etsmtl.ticketz.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

public class PaiementImpl implements IPaiementDAO {
	
	private static final Logger logger = Logger.getLogger(PaiementImpl.class);
	private static final String PREAUTH_URL = "http://gti525.herokuapp.com/transactions.xml?api_key={api_key}&store_id={store_id}&order_id={order_id}"+
			"&first_name={first_name}&last_name={last_name}&card_number={card_number}&security_code={security_code}"+
			"&year={year}&month={month}&amount={amount}";
	private static final String AUTH_URL = "http://gti525.herokuapp.com/transactions/{transaction_id}.xml?api_key={api_key}&store_id={store_id}";

	@Override
	public ReponseSystemePaiementTO approuverTransaction(RequeteAuthorisationTO _requete) {
		ReponseSystemePaiementTO response = new ReponseSystemePaiementTO();
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> varsAuth = new HashMap<String, String>();
		varsAuth.put("api_key", _requete.getApi_key());
		varsAuth.put("store_id", Integer.toString(_requete.getStore_id()));
		varsAuth.put("transaction_id", Long.toString(_requete.getTransaction_id()));
		
		String result = restTemplate.getForObject(AUTH_URL, String.class, varsAuth);
		logger.info("Transaction approbation : " + result);
		try {
			InputSource source = new InputSource(new StringReader(result));
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(source);
			XPath xpath = XPathFactory.newInstance().newXPath();
			response.setMessage(xpath.evaluate("/order/messages", doc));
			response.setCode(Integer.parseInt(xpath.evaluate("/order/code", doc)));
			response.setStatus(xpath.evaluate("/order/status", doc));
			response.setTransactionId(Integer.parseInt(xpath.evaluate("/order/transaction-id", doc)));
		} catch (ParserConfigurationException e) {
			logger.error(e.getClass() + " : " + e.getMessage());
		} catch (SAXException e) {
			logger.error(e.getClass() + " : " + e.getMessage());
		} catch (IOException e) {
			logger.error(e.getClass() + " : " + e.getMessage());
		} catch (XPathExpressionException e) {
			logger.error(e.getClass() + " : " + e.getMessage());
		}
		
		return response;
	}

	@Override
	public ReponseSystemePaiementTO effectuerPreauthorisation(InformationsPaiementTO _info) {
		ReponseSystemePaiementTO response = new ReponseSystemePaiementTO();
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("api_key", _info.getApi_key());
		vars.put("store_id", Integer.toString(_info.getStore_id()));
		vars.put("order_id", Long.toString(_info.getOrder_id()));
		vars.put("first_name", _info.getFirst_name());
		vars.put("last_name", _info.getLast_name());
		vars.put("card_number", Long.toString(_info.getCard_number()));
		vars.put("security_code", Integer.toString(_info.getSecurity_code()));
		vars.put("year", Integer.toString(_info.getYear()));
		vars.put("month", Integer.toString(_info.getMonth()));
		vars.put("amount", _info.getAmount().toString());
		
		String result = restTemplate.postForObject(PREAUTH_URL, null, String.class, vars);
		logger.info("Preauthorization : " + result);
		try {
			InputSource source = new InputSource(new StringReader(result));
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(source);
			XPath xpath = XPathFactory.newInstance().newXPath();
			response.setMessage(xpath.evaluate("/order/messages", doc));
			response.setCode(Integer.parseInt(xpath.evaluate("/order/code", doc)));
			response.setStatus(xpath.evaluate("/order/status", doc));
			response.setTransactionId(Integer.parseInt(xpath.evaluate("/order/transaction-id", doc)));
		} catch (ParserConfigurationException e) {
			logger.error(e.getClass() + " : " + e.getMessage());
		} catch (SAXException e) {
			logger.error(e.getClass() + " : " + e.getMessage());
		} catch (IOException e) {
			logger.error(e.getClass() + " : " + e.getMessage());
		} catch (XPathExpressionException e) {
			logger.error(e.getClass() + " : " + e.getMessage());
		}
		
		
		return response;
	}

}
