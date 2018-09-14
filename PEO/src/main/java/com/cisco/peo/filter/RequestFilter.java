package com.cisco.peo.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class RequestFilter implements Filter {

	@Override
	public void destroy() {
		//do something here
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {

			String mdcData = String.format("[userId:%s | requestId:%s] ", user(request), requestId());
			MDC.put("mdcData", mdcData); // Referenced from logging
											// configuration.
			chain.doFilter(request, response);
		} finally {
			MDC.clear();
		}
	}

	private String user(ServletRequest request) {
		String userId = request.getParameter("USER_ID");
		return null != userId && !"".equals(userId.trim()) ? userId : "";
	}

	private String requestId() {
		return UUID.randomUUID().toString();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// do something here
	}

}
