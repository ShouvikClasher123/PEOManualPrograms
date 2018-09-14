package com.cisco.peo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author amigaura
 *
 */
@Repository
public class SILogger {

	private static final Logger LOG = LoggerFactory.getLogger(SILogger.class);

	public void logException(PEOException e) {
		if(LOG.isInfoEnabled()){
			LOG.info(ExceptionUtils.getExceptionLogSubject(e.getErrorMessage().trim(), e.getThrowable()));
		}
	}

}
