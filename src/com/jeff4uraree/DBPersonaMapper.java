package com.jeff4uraree;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DBPersonaMapper implements RowMapper<OutputPersona>{

	@Override
	public OutputPersona mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		OutputPersona outputPersona = new OutputPersona();
		// Set fields
		
		outputPersona.setPersonaID(rs.getInt("persona_id"));
		outputPersona.setPersonaName(rs.getString("persona_name"));
		//persona.setArcanaID(rs.getInt("arcana_id"));
		//outputPersona.setArcanaType(rs.getString("arcana_name"));
		
		return outputPersona;
	}
	
	

}
