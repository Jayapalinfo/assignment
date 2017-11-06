package com.views;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.form.CustomerForm;
import com.model.Customer;

@RunWith(MockitoJUnitRunner.class)
public class TestConfirmFTL {
	
	@Test
	public void testGenerateList() throws Exception {
		Map<String, Object> root = new HashMap<String, Object>();
		Customer customer= new Customer();
		customer.setCustomerName("John");
		customer.setDirectDebitId(12345l);
		customer.setDirectDebitType("Recurring");
		root.put("customer", customer);
		String output = FreeMarkerUtils.applyTemplate("src/test/resources/views/ftl/confirm.ftl", root);
		Assert.assertTrue(output.contains("John"));
		Assert.assertTrue(output.contains("Recurring"));
	}

}
