package ns.ap.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.collections.MapUtils;
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
		return this.queryForList(sql, null);
	}
	
	public List<Map<String, Object>> queryForList(String sql, Map<String, Object> params)
	{
		if(params == null || MapUtils.isEmpty(params))
		{
			params = new HashMap<String, Object>();
		}
		//execute SQL.
		List<Map<String, Object>> queryResult = this.namedParameterJdbcTemplate.queryForList(sql, params);

		//this.namedParameterJdbcTemplate.update(sql, paramMap)
		
		//return
		return queryResult;
	}
}
