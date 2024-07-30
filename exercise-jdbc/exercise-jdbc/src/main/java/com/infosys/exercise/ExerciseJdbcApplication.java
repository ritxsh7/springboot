package com.infosys.exercise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.exercise.config.AppConfig;
import com.infosys.exercise.dao.DirectorDAO;
import com.infosys.exercise.dao.DirectorDAOImpl;
import com.infosys.exercise.dao.FilmDAO;
import com.infosys.exercise.dao.FilmDAOImpl;
import com.infosys.exercise.model.Director;
import com.infosys.exercise.model.Film;


@SpringBootApplication
public class ExerciseJdbcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ExerciseJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		FilmDAO film = context.getBean(FilmDAOImpl.class);
		DirectorDAO director = context.getBean(DirectorDAOImpl.class);
		
		
//		DISPLAYING FILMS
		System.out.println("DISPLAYING FILMS");
		for(Film f : film.display()) {
			System.out.println(f);
		}
		
//		INSERTING FILM
//		Film myFilm = new Film(102, "Shawshank Redemption");
//		if(film.insert(myFilm)) {
//			System.out.println("INSERTED FILM");
//		}
		
		
//		INSERTING DIRECTOR
//		Director myDirector = new Director(1, "Anurag Kashyap");
//		if(director.insert(myDirector)) {
//			System.out.println("INSERTED DIRECTOR");
//		}
		
//		INSERT INTO FILM DB REFERENCE TABLE
//		film.insertInFilmDB();
		
//      FIND FILM AND DIRECTOR BY DEPT ID
		System.out.println("FILM BY ID 102");
		System.out.println(film.findByID(102));
		System.out.println("DIRECTOR BY FILM ID 102");
		System.out.println(director.findByFilmId(101));
		
//		
		
	}

}
