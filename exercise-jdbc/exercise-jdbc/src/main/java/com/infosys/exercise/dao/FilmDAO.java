package com.infosys.exercise.dao;

import java.util.List;

import com.infosys.exercise.model.Film;

public interface FilmDAO {
	public List<Film> display();
	public boolean insert(Film film);
	public Film findByID(Integer id);
	public void insertInFilmDB();
}
