package com.infosys.exercise.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.infosys.exercise.model.Director;
import com.infosys.exercise.model.DirectorMapper;


@Component
public class DirectorDAOImpl implements DirectorDAO{

	@Autowired
	private JdbcTemplate jdbc;
	
	private final String SQL_INSERT_DIRECTOR = "INSERT INTO DIRECTORS VALUES (?, ?)";
	private final String SQL_FINDBY_FILM_ID = "SELECT * FROM DIRECTORS JOIN FILM_DB USING(DIRECTOR_ID) JOIN FILMS USING(FILM_ID) WHERE FILM_ID = ?"; 
	
	@Override
	public boolean insert(Director director) {
		return jdbc.update(SQL_INSERT_DIRECTOR, director.getDirectorID(), director.getDirectorName()) > 0;
	}

	@Override
	public Director findByFilmId(Integer id) {
		return jdbc.queryForObject(SQL_FINDBY_FILM_ID, new Object[] {id}, new DirectorMapper());
	}
}
