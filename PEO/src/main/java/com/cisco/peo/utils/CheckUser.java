package com.cisco.peo.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.apache.log4j.Category;

public class CheckUser {
	public static int cntr = 0;

	public CheckUser() {
		//Logger.log.info("SecurityUtil-->Starts.....");
	}

	public static String getCurrentUser(HttpSession paramHttpSession) {
		String str = null;
		//Logger.log.info("(" + cntr++ + ")session::" + paramHttpSession);
		try {
			if (paramHttpSession != null) {
				try {
					str = (String) paramHttpSession.getAttribute("UserId");
					//Logger.log.debug("Security Util-->getCurrentUser*userID=:"
					//		+ str);
				} catch (Exception localException1) {
					//Logger.log
					//		.debug("SecurityUtil-->Exception--getCurrentUser()...>("
					//				+ cntr++ + ")exception:123");
				}
			} else {
				/*Logger.log
						.info("SecurityUtil-->getCurrentUser()...>("
								+ cntr++
								+ ") SecurityUtil.getCurrentUser: Session object is null.");
			*/}
			if (str == null) {
				return null;
			}
		} catch (Exception localException2) {
			/*Logger.log.error("SecurityUtil-->getCurrentUser()...>(" + cntr++
					+ ") SecurityUtil.getCurrentUser: Exception");
			localException2.printStackTrace();*/
		}
		return str;
	}

	public static void checkUserSession(
			HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse) {
		checkUserSession(paramHttpServletRequest, paramHttpServletResponse,
				null);
	}

	public static void checkUserSession(
			HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse, String paramString) {
		HttpSession localHttpSession = paramHttpServletRequest
				.getSession(false);
		String str = null;
		try {
			int i = 0;
			if (localHttpSession != null) {
				try {
					str = getCurrentUser(localHttpSession);
				} catch (Exception localException2) {
					/*Logger.log
							.error("SecurityUtil-->checkUserSession()...>*** Session null");
					Logger.log
							.error("SecurityUtil-->checkUserSession()...>("
									+ cntr++
									+ ") checkUserSession(request, response, gotonext) useid exception ("
									+ localException2.getMessage() + ")");*/
				}
				if (str == null) {
					/*Logger.log
							.info("SecurityUtil-->checkUserSession()...>("
									+ cntr++
									+ ") checkUserSession(request, response, gotonext) User is NULL: Hence Session has EXPIRED");
					*/
					i = 1;
				}
			} else {
				/*Logger.log
						.info("SecurityUtil-->checkUserSession()...>("
								+ cntr++
								+ ") checkUserSession(request, response, gotonext) Session is NULL: Hence Session has EXPIRED");
				*/i = 1;
			}
			if (i != 0) {
				/*Logger.log
						.error("SecurityUtil-->checkUserSession()...>("
								+ cntr++
								+ ") checkUserSession(request, response, gotonext) Redirect to SessionExpired/SessionExpiredTwo.jsp ...");
				*/RequestDispatcher localRequestDispatcher;
				if (paramString != null) {
					localRequestDispatcher = paramHttpServletRequest
							.getRequestDispatcher(paramString);
				} else {
					localRequestDispatcher = paramHttpServletRequest
							.getRequestDispatcher("/jsp/SessionExpired.jsp");
				}
				/*Logger.log
						.error("SecurityUtil-->checkUserSession()...>("
								+ cntr++
								+ ") checkUserSession(request, response, gotonext) before forward::"
								+ localRequestDispatcher.toString());
				Logger.log
						.error("SecurityUtil-->checkUserSession()...>("
								+ cntr++
								+ ") checkUserSession(request, response, gotonext) [END]");
				*/localRequestDispatcher.forward(paramHttpServletRequest,
						paramHttpServletResponse);
			}
		} catch (Exception localException1) {
			/*Logger.log
					.error("SecurityUtil-->checkUserSession()...>("
							+ cntr++
							+ ") checkUserSession(request, response, gotonext) EXCEPTION "
							+ localException1.toString());
			*/localException1.printStackTrace();
		}
	}

	public static boolean checkUserSession(
			HttpServletRequest paramHttpServletRequest) {
		HttpSession localHttpSession = paramHttpServletRequest
				.getSession(false);
		if (localHttpSession != null) {
			String str = getCurrentUser(localHttpSession);
			if (str != null) {
				return true;
			}
		}
		return false;
	}

	public static String getUserId(HttpSession paramHttpSession) {
		String str = null;
		Object localObject = paramHttpSession.getAttribute("UserId");
		if (localObject == null) {
			str = localObject.toString();
			//Logger.log.info("SecurityUtil-->getUserId()...End..userID::" + str);
		}
		return str;
	}
}
