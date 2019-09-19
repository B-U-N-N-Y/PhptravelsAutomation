package com.atmecs.phptravelsautomation.constants;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.phptravelsautomation.utils.ReadPropertiesFile;

/**
 * 
 * @author arjun.santra
 * 
 *         This class to load locator file
 *
 */
public class FindLocators {
	static Properties homepageloc;
	static Properties bookingoptionloc;
	static Properties bookingsummaryloc;
	static Properties invoiceloc;

	public FindLocators() {
		try {
			homepageloc = ReadPropertiesFile.loadProperty(FilePath.HOME_PAGE_LOCATOR_FILE);
			bookingoptionloc = ReadPropertiesFile.loadProperty(FilePath.BOOKING_OPTION_PAGE_LOCATOR_FILE);
			bookingsummaryloc = ReadPropertiesFile.loadProperty(FilePath.BOOKING_SUMMARY_PAGE_LOCATOR_FILE);
			invoiceloc = ReadPropertiesFile.loadProperty(FilePath.INVOICE_PAGE_LOCATOR_FILE);

		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * 
	 * @param key
	 * @return locators from the property file This method to get the locators
	 */
	public String gethomepagelocator(String key) {
		String value = homepageloc.getProperty(key);
		return value;

	}

	/**
	 * 
	 * @param key
	 * @return locators from the property file This method to get the locators
	 */
	public String getbookingoptionlocator(String key) {
		String value = bookingoptionloc.getProperty(key);
		return value;

	}

	/**
	 * 
	 * @param key
	 * @return locators from the property file This method to get the locators
	 */
	public String getbookingsummarylocator(String key) {
		String value = bookingsummaryloc.getProperty(key);
		return value;

	}

	/**
	 * 
	 * @param key
	 * @return locators from the property file This method to get the locators
	 */
	public String getinvoicelocator(String key) {
		String value = invoiceloc.getProperty(key);
		return value;

	}

}
