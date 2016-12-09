package com.jeff4uraree;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jeff4uraree.intf.DBDao;

public class DBInit{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);	
	}
	
	public OutputPersona findPersonaByName(String personaName) {
		String SQL = "select * from persona where persona_name = ?";
		OutputPersona persona = jdbcTemplateObject.queryForObject(SQL, new Object[]{personaName}, new DBPersonaMapper());
		return persona;
	}
}
