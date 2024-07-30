package com.infosys.exercise.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.infosys.exercise.model.Film;
import com.infosys.exercise.model.FilmMapper;


@Component
public class FilmDAOImpl implements FilmDAO{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	private final String SQL_DISPLAY_FILMS = "SELECT * FROM FILMS";
	private final String SQL_INSERT_FILM = "INSERT INTO FILMS VALUES (? , ?)";
	private final String SQL_FIND_FILM = "SELECT * FROM FILMS WHERE FILM_ID = ?";
	private final String SQL_INSERT_FILM_DB = "INSERT INTO FILM_DB VALUES (102, 1)";

	@Override
	public List<Film> display() {
		return jdbc.query(SQL_DISPLAY_FILMS, new FilmMapper());
	}

	@Override
	public boolean insert(Film film) {
		return jdbc.update(SQL_INSERT_FILM, film.getFilmId(), film.getFilmName()) > 0;
	}

	@Override
	public Film findByID(Integer id) {
		return jdbc.queryForObject(SQL_FIND_FILM, new Object[] {id}, new FilmMapper());
	}

	@Override
	public void insertInFilmDB() {
		jdbc.update(SQL_INSERT_FILM_DB);
	}
	
}
