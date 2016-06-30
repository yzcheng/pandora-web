package ns.ap.generic.vo;

import java.io.Serializable;
import java.util.Map;

public class GenericRequest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1965417972331436685L;

	private String ap_name;
	private String dao_name;
	private String method_name;
	private String nt_account;
	private outputFormat output_format;
	private Map<String, Object> filter;

	public String getAp_name()
	{
		return ap_name;
	}

	public void setAp_name(String ap_name)
	{
		this.ap_name = ap_name;
	}

	public String getDao_name()
	{
		return dao_name;
	}

	public void setDao_name(String dao_name)
	{
		this.dao_name = dao_name;
	}

	public String getMethod_name()
	{
		return method_name;
	}

	public void setMethod_name(String method_name)
	{
		this.method_name = method_name;
	}

	public String getNt_account()
	{
		return nt_account;
	}

	public void setNt_account(String nt_account)
	{
		this.nt_account = nt_account;
	}

	public Map<String, Object> getFilter()
	{
		return filter;
	}

	public void setFilter(Map<String, Object> filter)
	{
		this.filter = filter;
	}

	public outputFormat getOutput_format()
	{
		return output_format;
	}

	public void setOutput_format(outputFormat output_format)
	{
		this.output_format = output_format;
	}

	public enum outputFormat
	{
		JSON, STDF, DAO
	}

}
