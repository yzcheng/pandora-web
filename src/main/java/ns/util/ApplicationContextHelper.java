package ns.util;

import org.springframework.context.ApplicationContext;

/**
 * Provide non-spring bean to fetch spring bean.<br>
 * @author Kenny
 *
 */
public class ApplicationContextHelper
{
	private ApplicationContextHelper(){}
	
	private static ApplicationContext context;
	
	/**
	 * The set method will be called once when spring initialize.<br>
	 * @param context
	 */
	public static void setApplicationContext(ApplicationContext context)
	{
		if(ApplicationContextHelper.context == null)
			ApplicationContextHelper.context = context;
	}
	
	public static Object getBean(String name)
	{
		return ApplicationContextHelper.context.getBean(name);
	}
}
