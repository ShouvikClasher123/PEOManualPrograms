
package com.cisco.peo.exceptions;

public class ExceptionUtils {

	public static final String SYSTEM_ID = "SYSTEM_ID";
	public static final String SYSTEM_ERROR_CODE = "SYSTEM_ERROR_CODE";
	public static final String SYSTEM_ERROR_MESSAGE = "SYSTEM_ERROR_MESSAGE";
	public static final StringBuilder exceptionLogSubject = new StringBuilder();

	private ExceptionUtils(){
		
	}

	private static String getExceptionFileName(Throwable throwable) {
		return throwable.getStackTrace()[0].getFileName();
	}

	private static String getExceptionClassName(Throwable throwable) {
		return throwable.getStackTrace()[0].getClassName();
	}

	private static String getExceptionMethodName(Throwable throwable) {
		return throwable.getStackTrace()[0].getMethodName();
	}

	private static String getExceptionLineNumber(Throwable throwable) {
		return Integer.toString(throwable.getStackTrace()[0].getLineNumber());
	}

	public static String getExceptionLogSubject(String errorMessage, Throwable throwable) {
		exceptionLogSubject.setLength(0);
		return exceptionLogSubject.append(errorMessage + " : Exception occurred in method "
				+ getExceptionClassName(throwable) + "." + getExceptionMethodName(throwable) + " at line "
				+ getExceptionLineNumber(throwable) + " in file " + getExceptionFileName(throwable)).toString();

	}

}
