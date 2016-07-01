package ns.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect
{
	private static Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	public void before(JoinPoint joinPoint)
	{
		log.info("****** hijacked : {}.{} ******",  joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName());
	}
}
