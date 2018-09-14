package com.cisco.peo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBResourcesUtils {

	private DBResourcesUtils(){}

	private static Properties properties = CommonUtils.getProperties(Constant.PROP_CONNECTION_FILE);

	// ORACLE DB
	public static final String ORACLE_DRIVER = properties.getProperty("oracle.driver");

	public static final String ORACLE_DEV_URL = properties.getProperty("siadm.dev.url");
	public static final String ORACLE_SIADM_DEV_USERNAME = properties.getProperty("siadm.dev.username");
	public static final String ORACLE_SIADM_DEV_PWD = properties.getProperty("siadm.dev.pwd");
	
	public static final String ORACLE_STG_URL = properties.getProperty("siadm.stg.url1");
	public static final String ORACLE_SIADM_STG_USERNAME = properties.getProperty("siadm.stg.username");
	public static final String ORACLE_SIADM_STG_PWD = properties.getProperty("siadm.stg.pwd");
	
	private static final Logger LOG = LoggerFactory.getLogger(DBResourcesUtils.class);
	
	public static void closeOracleConnection(Connection connection) {
		try {
			if(null != connection){
				connection.close();
			}
		} catch (Exception ex) {
			if(LOG.isDebugEnabled()){
				LOG.debug(String.format("Unexpected exception on closing mongoDB connection: %s ", ex.getMessage()));
			}
		}
	}

	public static Connection getDBConnectionToSIADM() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Class.forName(DBResourcesUtils.ORACLE_DRIVER);
		conn = DriverManager.getConnection(DBResourcesUtils.ORACLE_DEV_URL, 
												DBResourcesUtils.ORACLE_SIADM_DEV_USERNAME,
												DBResourcesUtils.ORACLE_SIADM_DEV_PWD);
		return conn;
	}

}
