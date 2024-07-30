package com.infosys.exercise.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DirectorMapper implements RowMapper<Director>{

	@Override
	public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
		Director director = new Director();
		
		director.setDirectorID(rs.getInt("DIRECTOR_ID"));
		director.setDirectorName(rs.getString("DIRECTOR_NAME"));
		
		return director;
	}

}
