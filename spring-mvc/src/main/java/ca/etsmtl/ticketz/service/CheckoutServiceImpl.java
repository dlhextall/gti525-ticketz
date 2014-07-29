package ca.etsmtl.ticketz.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import ca.etsmtl.ticketz.dao.ICheckoutDao;
import ca.etsmtl.ticketz.form.CheckoutForm;
import ca.etsmtl.ticketz.model.Client;
import ca.etsmtl.ticketz.model.ClientOrder;
import ca.etsmtl.ticketz.model.CreditCard;

public class CheckoutServiceImpl implements ICheckoutService {
	
	@Autowired
	ICheckoutDao checkoutDao;

	@Override
	public void processClientOrder(CheckoutForm _form) {
		CreditCard creditCard = new CreditCard(_form.getCcNumber(), _form.getCcLastName(), _form.getCcFirstName());
		Client client = new Client(_form.getLastName(), _form.getFirstName(), _form.getAddress(), _form.getCity(), _form.getProvince(),
				_form.getCountry(), _form.getPostalCode(), _form.getTelephone(), creditCard);
		checkoutDao.addClient(client);
		ClientOrder clientOrder = new ClientOrder(DateTime.now(), client);
		checkoutDao.addClientOrder(clientOrder);
	}

}
