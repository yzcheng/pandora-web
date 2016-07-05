package ns.ap.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PandoraCommand implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8722782049828844855L;

	private String command;
	private String targetProtocol;
	private String targetName;
	private String targetAction;
	private String content;
	private Date updateTime;
	private String updateUser;

	// detail
	private List<PandoraCommandPara> commandParas;

	public String getCommand()
	{
		return command;
	}

	public void setCommand(String command)
	{
		this.command = command;
	}

	public String getTargetProtocol()
	{
		return targetProtocol;
	}

	public void setTargetProtocol(String targetProtocol)
	{
		this.targetProtocol = targetProtocol;
	}

	public String getTargetName()
	{
		return targetName;
	}

	public void setTargetName(String targetName)
	{
		this.targetName = targetName;
	}

	public String getTargetAction()
	{
		return targetAction;
	}

	public void setTargetAction(String targetAction)
	{
		this.targetAction = targetAction;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
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

	/**
	 * get parameters, return null if not parameters.
	 * @return
	 */
	public List<PandoraCommandPara> getCommandParas()
	{
		return commandParas;
	}

	public void setCommandParas(List<PandoraCommandPara> commandParas)
	{
		this.commandParas = commandParas;
	}

}
