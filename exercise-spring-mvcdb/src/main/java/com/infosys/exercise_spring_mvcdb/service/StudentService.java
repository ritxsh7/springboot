package com.infosys.exercise_spring_mvcdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.exercise_spring_mvcdb.entity.Student;
import com.infosys.exercise_spring_mvcdb.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository student;
	
	public Student addStudent(Student std) {
		return student.save(std);
	}
	
	public List<Student> getAllStudents(){
		return student.findAll();
	}
	
	public Student getById(Integer id) {
		return student.findById(id).get();
	}
	
	public void updateStudent(Integer marks, Integer id) {
		student.updateStudent(marks, id);
	}
	public void deleteById(Integer id) {
		student.deleteById(id);
	}
}
