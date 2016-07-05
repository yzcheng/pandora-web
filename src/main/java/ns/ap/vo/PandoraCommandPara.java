package ns.ap.vo;

import java.io.Serializable;
import java.util.Date;

public class PandoraCommandPara implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2738284656717108075L;

	private String command;
	private String paraName;
	private Date updateTime;
	private String updateUser;

	public String getCommand()
	{
		return command;
	}

	public void setCommand(String command)
	{
		this.command = command;
	}

	public String getParaName()
	{
		return paraName;
	}

	public void setParaName(String paraName)
	{
		this.paraName = paraName;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public String getUpdateUser()
	{
		return updateUser;
	}

	public void setUpdateUser(String updateUser)
	{
		this.updateUser = updateUser;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
