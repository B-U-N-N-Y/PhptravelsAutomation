package com.atmecs.phptravelsautomation.constants;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.phptravelsautomation.utils.ReadPropertiesFile;
/**
 * 
 * @author arjun.santra
 * 
 * This class to load validation data file
 *
 */
public class FindValidateData {
	static Properties phptravelsvalidate;

	public FindValidateData() {
		try {
			phptravelsvalidate = ReadPropertiesFile.loadProperty(FilePath.VALIDATION_FILE);
		} catch (IOException e) {
			e.getMessage();
		}
	}
/**
 *  This method to get the Data for validation
 * @param key
 * @return validation data
 *
 */
	public String getData(String key) {
		String value = phptravelsvalidate.getProperty(key);
		return value;

	}

}
