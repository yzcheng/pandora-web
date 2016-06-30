package ns.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextAssigner implements ApplicationContextAware
{
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		ApplicationContextHelper.setApplicationContext(applicationContext);
	}
}
