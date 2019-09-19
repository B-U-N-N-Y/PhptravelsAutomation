package com.atmecs.phptravelsautomation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.constants.FindValidateData;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.logreports.LogReport;

/**
 * 
 * @author arjun.santra This class operate the Booking option page
 */
public class BookingOptionPage {

	static LogReport log = new LogReport();

	/**
	 * 
	 * @param loc
	 */
	public static void bookingPageTest(WebDriver driver,FindLocators loc) {
		
		CommonUtility.clickElement(loc.getbookingoptionlocator("loc.tourdetails.btn"));
		CommonUtility.scrollDownPage(5000);
		CommonUtility.clickElement(loc.getbookingoptionlocator("loc.adults.dpdn"));
		CommonUtility.clickElement(loc.getbookingoptionlocator("loc.adultsnumber.btn"));
		CommonUtility.clickElement(loc.getbookingoptionlocator("loc.children.dpdn"));
		CommonUtility.clickElement(loc.getbookingoptionlocator("loc.chilnumber.btn"));
	}

	/**
	 * 
	 * @param loc
	 * @param validatedata
	 */
	public static void bookingPageValidate(FindLocators loc, FindValidateData validatedata) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = CommonUtility.getText(loc.getbookingoptionlocator("loc.bookingoption.totalcost.txt"));
		Assert.assertEquals(actual, validatedata.getData("bookingpage.totalamount_data"), "Failed");
		log.info("The total amount in booking option page: " + actual);
		log.info("The total amount is validate succesfully");

	}
}
