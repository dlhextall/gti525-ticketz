package ca.etsmtl.ticketz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import ca.etsmtl.ticketz.dao.TicketzProvider;
import ca.etsmtl.ticketz.model.Panier;
import ca.etsmtl.ticketz.model.Show;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends AbstractController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	HttpSession session;
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	Timer timer = new Timer();
	
	
	private final int MINUTES=20;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest _req, HttpServletResponse _resp) throws Exception {
		ModelAndView model = new ModelAndView("home");
		setSession(_req.getSession());
		//Panier panier = (Panier)session.getAttribute("panier");
		 //panier= new Panier();
		//session.setAttribute("panier", panier); 
		model.addObject("spectacles", TicketzProvider.getFeaturedShows());
		
		/*TimerTask task = new TimerTask() {
			
			  public void run() {
				  session.invalidate();
				 System.out.println("Global Timer Current time is :: "+ new Date());
			  }};
			  
			  
			  timer.scheduleAtFixedRate(task, 0, 1200000);*/
			  session.invalidate();
		return model;
	}
	

	/*@Scheduled(fixedDelay = 5000)
    public void demoServiceMethod()
    {
       //System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
		Panier panier = (Panier)request.getSession().getAttribute("panier");
		panier= new Panier();
		request.getSession().setAttribute("panier", panier);
		System.out.println("Global Timer Current time is :: "+ new Date());
    }*/
	
	      
	
	
}
