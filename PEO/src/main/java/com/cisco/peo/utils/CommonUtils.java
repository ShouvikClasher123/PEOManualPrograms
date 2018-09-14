package com.cisco.peo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {

	private CommonUtils(){
		
	}
	private static final Logger LOG = LoggerFactory.getLogger(CommonUtils.class);
	
	public static Properties getProperties(String propertiesFileName) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = DBResourcesUtils.class.getResourceAsStream("/" + propertiesFileName);
			// load a properties file
			prop.load(input);
		} catch (IOException ex) {
			if(LOG.isDebugEnabled()){
				LOG.debug(String.format("IO Exception of DBResourcesUtils class: %s", ex.getMessage()));
			}
		} catch (Exception ex) {
			if(LOG.isDebugEnabled()){
				LOG.debug(String.format("Exception occurred in getProperties method of DBResourcesUtils class: %s", ex.getMessage()));
			}
		} finally {
			if (null != input) {
				try {
					input.close();
				} catch (IOException e) {
					LOG.error("some exception message {0}", e);
				}
			}
		}
		return prop;
	}

}
