package ns.ap.dao;

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

	public List<Map<String, Object>> queryForList(String sql)
	{
		//execute SQL.
		List<Map<String, Object>> queryResult = this.namedParameterJdbcTemplate.queryForList(sql, new HashMap<String, Object>());
		
		//return
		return queryResult;
	}
}
