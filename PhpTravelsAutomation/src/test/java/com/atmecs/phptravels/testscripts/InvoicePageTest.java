package com.atmecs.phptravels.testscripts;

import org.testng.annotations.Test;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.constants.FindValidateData;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.pages.InvoicePage;

public class InvoicePageTest extends BookingSummaryPageTest{
	
	

	@Test(priority = 9)
	public void invoicePageValidate() {

		if (browser.equalsIgnoreCase("chrome")) {
			CommonUtility.clickElement(loc.getinvoicelocator("loc.payonarrival.btn"));

		} else if (browser.equalsIgnoreCase("firefox")) {
			CommonUtility.clickElement(loc.getinvoicelocator("loc.payonarrival.btn"));
			CommonUtility.clickElement(loc.getinvoicelocator("loc.payonarrival.btn"));
		}
		InvoicePage.invoicevalidation(loc, validatedata,driver);
	}

}
