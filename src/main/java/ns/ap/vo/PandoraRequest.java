package ns.ap.vo;

import java.io.Serializable;
import java.util.Map;

public class PandoraRequest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1965417972331436685L;

	private String command;
	private Map<String, Object> params;

	public String getCommand()
	{
		return command;
	}

	public void setCommand(String command)
	{
		this.command = command;
	}

	public Map<String, Object> getParams()
	{
		return params;
	}

	public void setParams(Map<String, Object> params)
	{
		this.params = params;
	}

}
