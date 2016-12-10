package com.jeff4uraree;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DBFusionMapper implements RowMapper<OutputArcana>{

	@Override
	public OutputArcana mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		OutputArcana outputArcana = new OutputArcana();
		
		outputArcana.setArcana(rs.getString("outcome"));
		
		return outputArcana;
	}

}
