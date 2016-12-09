package com.jeff4uraree.intf;

import javax.sql.DataSource;

import com.jeff4uraree.OutputPersona;

public interface DBDao {

	public void setDataSource(DataSource ds);
	
	public OutputPersona findPersonaByName(String personaName);
}
