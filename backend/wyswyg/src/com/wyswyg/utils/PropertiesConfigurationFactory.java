package com.wyswyg.utils;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class PropertiesConfigurationFactory {

	public static String getPropertiesConfiguration(String p) throws ConfigurationException {
		Configurations configurations = new Configurations();

		// get properties file and assign to PropertiesConfiguration reference
		PropertiesConfiguration config = configurations.properties("configuration.properties");

		if (config == null) {
			throw new ConfigurationException("Error! couldn't find configuration property");
		}
		// manually get properties
		return (String) config.getProperty(p);

	}
}
