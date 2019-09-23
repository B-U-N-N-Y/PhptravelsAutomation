package com.atmecs.phptravelsautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.constants.FindValidateData;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.logreports.LogReport;

/**
 * This class operate the Home page
 * 
 * @author arjun.santra
 *
 */
public class HomePage {
	static LogReport log = new LogReport();

	public static void changeCurrency(WebDriver driver, FindLocators loc) {
		Actions action = new Actions(driver);
		WebElement wb = CommonUtility.getElement(loc.gethomepagelocator("loc.currencyexchange.txt"));
		if (!wb.getText().equals("USD")) {
			action.click(wb).build().perform();
			CommonUtility.clickElement(loc.gethomepagelocator("loc.usdcurrency.btn"));
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

	}

	/**
	 * 
	 * @param driver
	 * @param loc
	 * @param validatedata
	 */
	public static void invalidCheckinDateValidation(WebDriver driver, FindLocators loc, FindValidateData validatedata) {
		if(CommonUtility.isElementVisible(loc.gethomepagelocator("loc.acceptcookie.btn")))
		CommonUtility.clickElement(loc.gethomepagelocator("loc.acceptcookie.btn"));
		CommonUtility.clickElement(loc.gethomepagelocator("loc.tours.btn"));
		CommonUtility.clickElement(loc.gethomepagelocator("loc.checkindate.btn"));
		CommonUtility.clearTextData(loc.gethomepagelocator("loc.checkindate.btn"));
		CommonUtility.clickAndSendText(loc.gethomepagelocator("loc.checkindate.btn"), 30,
				validatedata.getData("homepage.checkin_date_input_data"));
		CommonUtility.clickElement(loc.gethomepagelocator("loc.homepage.search.btn"));
		System.out.println("pass");
		Assert.assertEquals(driver.getTitle(), validatedata.getData("homepage.checkin_date_validate_data"),
				"Checkin date working properly");
		log.info("Next page title: " + driver.getTitle());
		log.info("Checkin date not working properly");

	}

	/**
	 * 
	 * @param loc
	 * @param validatedata
	 */
	public static void cityInputValidation(FindLocators loc, FindValidateData validatedata) {
		CommonUtility.clickElement(loc.gethomepagelocator("loc.backtohomapage.btn"));
		CommonUtility.clickElement(loc.gethomepagelocator("loc.tours.btn"));
		CommonUtility.clickElement(loc.gethomepagelocator("loc.city.btn"));
		CommonUtility.clickAndSendText(loc.gethomepagelocator("loc.cityinput.btn"), 30,
				validatedata.getData("homepage.city_validate_input_data"));
		String actual = CommonUtility.getText(loc.gethomepagelocator("loc.invalidcityinput.txt"));
		Assert.assertEquals(actual, validatedata.getData("homepage.city_validate_data"), "City Validation Failed");
		log.info("city validate data=" + actual);
		log.info("city input validation passed");
	}

	/**
	 * 
	 * @param loc
	 * @param city
	 * @param date
	 */
	public static void homePageTest(FindLocators loc, String city, String date) {

		CommonUtility.clearTextData(loc.gethomepagelocator("loc.cityinput.btn"));
		CommonUtility.clickAndSendText(loc.gethomepagelocator("loc.cityinput.btn"), 30, city);
		CommonUtility.clickElement(loc.gethomepagelocator("loc.citysearchoption.btn"));
		CommonUtility.clearTextData(loc.gethomepagelocator("loc.checkindate.btn"));
		CommonUtility.clickAndSendText(loc.gethomepagelocator("loc.checkindate.btn"), 30, date);
		CommonUtility.clickElement(loc.gethomepagelocator("loc.guests.dpdn"));
		CommonUtility.clickElement(loc.gethomepagelocator("loc.guestsnumber.btn"));
		CommonUtility.clickElement(loc.gethomepagelocator("loc.homepage.search.btn"));
	}

	public static void homePageVerification(WebDriver driver, FindValidateData validateData) {
		
		Assert.assertEquals(driver.getTitle(), validateData.getData("homepage.title_validate_data"),
				"Home page is not landing");
		log.info("Home page title: " + driver.getTitle());
		log.info("Home page URL verified successfully");
	}
}
