package ns.ap.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import ns.ap.dao.GenericDAO;
import ns.ap.dao.PandoraDAO;
import ns.ap.vo.PandoraCommand;
import ns.ap.vo.PandoraRequest;
import ns.util.ApplicationContextHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/MyController")
public class MyController
{
	@Autowired
	private GenericDAO genericDAO;
	
	@Autowired
	private PandoraDAO pandoraDAO;
	
	@Resource(name="pandora")
	private DataSource pandoraDataSource;
	
	@RequestMapping(value="/viewPandora/{command}/{format}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object viewPandora(@PathVariable("command") String command, @PathVariable("format") String format, Model model) throws Exception
	{
		PandoraCommand pCmd = pandoraDAO.querybyCommand(command);
		if(pCmd == null)
			throw new Exception(MessageFormat.format("Pandora Command {0} is not found!", command));
		
		List<Map<String, Object>> result = null;
		
		Protocol protocal = Protocol.valueOf(pCmd.getTargetProtocol());
		switch(protocal)
		{
			case JDBC:
				DataSource ds = (DataSource) ApplicationContextHelper.getBean(pCmd.getTargetName());
				result = genericDAO.setDataSource(ds).queryForList(pCmd.getContent());
				break;
		}
		
		return result;
	}
	
	@RequestMapping(value="/pandoraService", method = {RequestMethod.GET, RequestMethod.POST}, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object pandoraService(@RequestBody PandoraRequest request) throws Exception
	{
		PandoraCommand pCmd = pandoraDAO.querybyCommand(request.getCommand());
		if(pCmd == null)
			throw new Exception(MessageFormat.format("Pandora Command {0} is not found!", request.getCommand()));
		
		Object result = null;
		
		Protocol protocal = Protocol.valueOf(pCmd.getTargetProtocol());
		Action action = Action.valueOf(pCmd.getTargetAction());
		
		switch(protocal)
		{
			case JDBC:
				DataSource ds = (DataSource) ApplicationContextHelper.getBean(pCmd.getTargetName());
				result = genericDAO.setDataSource(ds).queryForList(pCmd.getContent(), request.getParams());
				break;
		}
		
		return result;
	}
	
	/**
	 * Create the available protocol
	 * @author Kenny
	 *
	 */
	public enum Protocol
	{
		JDBC
	}
	
	public enum Action
	{
		QUERY
	}
}
