package ns.ap.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class GenericDAO
{
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public GenericDAO setDataSource(DataSource dataSource)
	{
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		return this;
	}

	public List<Map<String, Object>> findByCommand(String command)
	{
		//find SQL by command.
		
		//execute SQL.
		List<Map<String, Object>> xxx = this.namedParameterJdbcTemplate.queryForList("select sysdate() from dual", new HashMap<String, Object>());
		//return
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("BOOK_NAME", "愛麗絲的夢遊仙境");
		return Arrays.asList(m);
	}
}
