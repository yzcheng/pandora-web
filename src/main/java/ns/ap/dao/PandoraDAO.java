package ns.ap.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ns.ap.vo.PandoraCommand;
import ns.util.ApplicationContextHelper;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class PandoraDAO
{
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate()
	{
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public PandoraCommand querybyCommand(String command)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("command", command);
		
		PandoraCommand queryResult = this.namedParameterJdbcTemplate.query("select * from pandora_command where command = :command", params, new PandoraCommandMap() );
		
		//return
		return queryResult;
	}
	
	class PandoraCommandMap implements ResultSetExtractor<PandoraCommand>{

		@Override
		public PandoraCommand extractData(ResultSet rs) throws SQLException, DataAccessException
		{
			PandoraCommand vo = new PandoraCommand();
			while(rs.next())
			{
				vo.setCommand(rs.getString("COMMAND"));
				vo.setType(rs.getString("TYPE"));
				vo.setInstanceName(rs.getString("INSTANCE_NAME"));
				vo.setCategory(rs.getString("CATEGORY"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setUpdateTime(rs.getDate("UPDATE_TIME"));
				vo.setUpdateUser(rs.getString("UPDATE_USER"));
			}
			return vo;
		}
		
	}
}
