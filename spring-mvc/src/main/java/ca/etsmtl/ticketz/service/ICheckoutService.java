package ca.etsmtl.ticketz.service;

import ca.etsmtl.ticketz.form.CheckoutForm;

public interface ICheckoutService {
	
	public void processClientOrder(CheckoutForm _form);
	
}
