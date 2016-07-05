package ns.ap.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ns.ap.vo.PandoraCommand;
import ns.ap.vo.PandoraCommandPara;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
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
		
		PandoraCommand commandResult = this.namedParameterJdbcTemplate.query("select * from pandora_command where command = :command", params, new PandoraCommandMap() );
		
		List<PandoraCommandPara> paraResult = this.namedParameterJdbcTemplate.query("select * from pandora_command_para where command = :command", params, new PandoraCommandParaMap() );
		commandResult.setCommandParas(paraResult);
		
		//return
		return commandResult;
	}
	
	class PandoraCommandMap implements ResultSetExtractor<PandoraCommand>{

		@Override
		public PandoraCommand extractData(ResultSet rs) throws SQLException, DataAccessException
		{
			PandoraCommand vo = new PandoraCommand();
			while(rs.next())
			{
				vo.setCommand(rs.getString("COMMAND"));
				vo.setTargetProtocol(rs.getString("TARGET_PROTOCOL"));
				vo.setTargetName(rs.getString("TARGET_NAME"));
				vo.setTargetAction(rs.getString("TARGET_ACTION"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setUpdateTime(rs.getDate("UPDATE_TIME"));
				vo.setUpdateUser(rs.getString("UPDATE_USER"));
			}
			return vo;
		}
		
	}
	
	class PandoraCommandParaMap implements RowMapper<PandoraCommandPara>{

		@Override
		public PandoraCommandPara mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			PandoraCommandPara vo = new PandoraCommandPara();
			while(rs.next())
			{
				vo.setCommand(rs.getString("COMMAND"));
				vo.setParaName(rs.getString("PARA_NAME"));
				vo.setUpdateTime(rs.getDate("UPDATE_TIME"));
				vo.setUpdateUser(rs.getString("UPDATE_USER"));
			}
			return vo;
		}
		
	}
}
