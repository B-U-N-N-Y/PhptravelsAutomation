package com.atmecs.phptravels.testscripts;

import org.testng.annotations.Test;

import com.atmecs.phptravelsautomation.constants.FindValidateData;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.pages.BookingOptionPage;

public class BookingOptionTestScript extends HomePageTestScript {

	

	@Test(priority = 3)
	public void BookingOption() {
		
		
		BookingOptionPage.bookingPageTest(driver,loc);
		BookingOptionPage.bookingPageValidate(loc, validatedata);
		CommonUtility.clickElement(loc.getbookingoptionlocator("loc.bookingoption.booknow.btn"));
	}
}
