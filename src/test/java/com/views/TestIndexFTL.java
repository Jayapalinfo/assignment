package com.views;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.form.CustomerForm;
@RunWith(MockitoJUnitRunner.class)
public class TestIndexFTL {
	
	@Test
	public void testGenerateList() throws Exception {
		Map<String, Object> root = new HashMap<String, Object>();
		String errorMessage="Exception";
		CustomerForm customerForm= new CustomerForm();
		customerForm.setCustomerName("John");
		customerForm.setDirectDebitId(12345l);
		customerForm.setDirectDebitType("Recurring");
		root.put("errorMessage", errorMessage);
		root.put("customerForm", customerForm);
		
		Map<String, String> directDebitTypes = new LinkedHashMap<>();
		directDebitTypes.put("One-off", "One-off");
		directDebitTypes.put("Recurring", "Recurring");
		root.put("directDebitTypes", directDebitTypes);
		
		String output = FreeMarkerUtils.applyTemplate("src/test/resources/views/ftl/index.ftl", root);
		Assert.assertTrue(output.contains("Exception"));
	}

}
