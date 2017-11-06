package com.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exception.ApplicationException;
import com.form.CustomerForm;
import com.model.Customer;
import com.service.DirectDebitService;

/**
 * Online Direct debit cancellation controller
 * 
 * @author Jayapal
 *
 */
@Controller
public class DirectDebitCancelController {

	@Autowired
	DirectDebitService userService;

	private static final Logger LOGGER = Logger.getLogger(DirectDebitCancelController.class);

	/**
	 * Renders the user form via freemarker template
	 * 
	 * @param model
	 * @return The index view (FTL)
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String customerForm(Model model) {
		LOGGER.info("Inside index...");
		CustomerForm customerForm = new CustomerForm();
		model.addAttribute("customerForm", customerForm);
		return "index";

	}

	/**
	 * Cancel the given debit id and show the confirmation message
	 * 
	 * @param model
	 * @param customerForm
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String cancelDirectDebit(Model model, @ModelAttribute("customerForm") CustomerForm customerForm) {
		LOGGER.info("cancelling DirectDebit...");
		try {
			Customer customer = userService.cancelDirectDebit(customerForm);
			model.addAttribute("customer", customer);
			return "confirm";
		} catch (ApplicationException applicationException) {
			// Catch application specific exceptions
			model.addAttribute("errorMessage", applicationException.getMessage());
			LOGGER.error(applicationException.getMessage(), applicationException);
		} catch (Exception exception) {
			// Catch generic exceptions
			model.addAttribute("errorMessage", exception.getMessage());
			LOGGER.error(exception.getMessage(), exception);
		}
		return "index";
	}

	/**
	 * Get the available direct debit types
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ModelAttribute("directDebitTypes")
	protected Map<String, String> referenceData() {
		LOGGER.info("cancelling Direct Debit type...");
		Map<String, String> directDebitTypes = new LinkedHashMap<>();
		directDebitTypes.put("One-off", "One-off");
		directDebitTypes.put("Recurring", "Recurring");
		return directDebitTypes;
	}

}