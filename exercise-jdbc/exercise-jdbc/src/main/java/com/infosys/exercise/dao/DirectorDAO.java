package com.infosys.exercise.dao;

import com.infosys.exercise.model.Director;

public interface DirectorDAO {
	public boolean insert(Director director);
	public Director findByFilmId(Integer id);
}
