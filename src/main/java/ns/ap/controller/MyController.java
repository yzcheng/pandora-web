package ns.ap.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import ns.ap.dao.GenericDAO;
import ns.ap.dao.PandoraDAO;
import ns.ap.generic.vo.GenericRequest;
import ns.ap.vo.PandoraCommand;
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
		
		if(pCmd.getType().equals("JDBC"))
		{
			String dsName = MessageFormat.format("{0}{1}", pCmd.getInstanceName(), pCmd.getCategory());
			DataSource ds = (DataSource) ApplicationContextHelper.getBean(dsName);
			result = genericDAO.setDataSource(ds).queryForList(pCmd.getContent());
		}
		
		return result;
	}
	
	@RequestMapping(value="/service", method = {RequestMethod.GET, RequestMethod.POST}, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Map<String, Object>> service(@RequestBody GenericRequest request) throws Exception
	{
		DataSource ds = (DataSource) ApplicationContextHelper.getBean("demo");
		List<Map<String, Object>> result = genericDAO.setDataSource(ds).queryForList(request.getMethod_name());
		return result;
	}
}
