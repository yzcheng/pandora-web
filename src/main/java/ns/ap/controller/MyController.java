package ns.ap.controller;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import ns.ap.dao.GenericDAO;
import ns.ap.generic.vo.GenericRequest;
import ns.util.ApplicationContextHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="/sayHello", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String sayHello(Model model) throws Exception
	{
		return "Hello";
	}
	
	@RequestMapping(value="/service", method = {RequestMethod.GET, RequestMethod.POST}, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String service(@RequestBody GenericRequest request) throws Exception
	{
		DataSource ds = (DataSource) ApplicationContextHelper.getBean("demo");
		List<Map<String, Object>> result = genericDAO.setDataSource(ds).findByCommand(request.getMethod_name());
		return "Hello";
	}
}
