package com.infosys.exercise.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FilmMapper implements RowMapper<Film>{

	@Override
	public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Film film = new Film();
		
		film.setFilmId(rs.getInt("FILM_ID"));
		film.setFilmName(rs.getString("FILM_NAME"));
		
		return film;
	}
	
}
