package com.cisco.peo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author amigaura
 *
 */
@Aspect
@Component
public class LogTimeAspect {


	
	private static final Logger LOG = LoggerFactory.getLogger(LogTimeAspect.class);

	//@Around("execution(public * com.cisco.si.*.*.*(..))")
	public Object logDuration(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		if(LOG.isInfoEnabled()){
			LOG.info("Entered into " + proceedingJoinPoint.getSignature().getName() + " method of "
					+ proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName());
		}

		Object value;
		try {
			value = proceedingJoinPoint.proceed();
			return value;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw e;
		} finally {
			long duration = System.currentTimeMillis() - start;
			if(LOG.isInfoEnabled()){
				LOG.info("Exiting from " + proceedingJoinPoint.getSignature().getName() + " method of "
						+ proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName() + ". Execution time is "
						+ duration + " ms");
			}
		}
	}

}
