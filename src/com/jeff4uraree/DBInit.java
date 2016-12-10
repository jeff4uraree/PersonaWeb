package com.jeff4uraree;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jeff4uraree.intf.DBDao;
import com.jeff4uraree.utils.PersonaUtils;

public class DBInit{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);	
	}
	
	public OutputPersona findPersonaByName(String personaName) {
		String SQL = "select * from personaadv where persona_name = ?";
		OutputPersona persona = jdbcTemplateObject.queryForObject(SQL, new Object[]{personaName}, new DBPersonaMapper());
		return persona;
	}
	
	public OutputPersona findPersonaByTraits(String outputArcana, Integer avgLvl) {
		String SQL  = "select * from personaadv where arcana = ? and base_level > ? order by base_level asc limit 1";
		OutputPersona persona = jdbcTemplateObject.queryForObject(SQL, new Object[]{outputArcana, avgLvl}, new DBPersonaMapper());
		return persona;
	}
	
	public OutputArcana findOutputArcana(String arcana1, String arcana2) {
		String SQL = "select * from fusion where arcana1 = ? and arcana2 = ?";
		OutputArcana arcana = jdbcTemplateObject.queryForObject(SQL, new Object[]{arcana1, arcana2}, new DBFusionMapper());
		
		return arcana;
	}
	
	public OutputPersona findPersonaFusionTwoWay(String persona1Name, String persona2Name) {
		
		OutputPersona persona1 = findPersonaByName(persona1Name);
		OutputPersona persona2 = findPersonaByName(persona2Name);
		
		OutputArcana arcana = findOutputArcana(persona1.getArcanaType(), persona2.getArcanaType());
		Integer avgLevel = PersonaUtils.getAverageLevel(persona1.getLevel(), persona2.getLevel());
		
		OutputPersona outcomePersona = findPersonaByTraits(arcana.getArcana(), avgLevel);
		
		return outcomePersona;
	}
}
